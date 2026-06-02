package dev.antonio.barbearia.projeto_barbearia.services;

import dev.antonio.barbearia.projeto_barbearia.dtos.ServiceDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.ServiceEntity;
import dev.antonio.barbearia.projeto_barbearia.mapper.ServiceMapper;
import dev.antonio.barbearia.projeto_barbearia.repositories.BarberShopRepository;
import dev.antonio.barbearia.projeto_barbearia.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    private final BarberShopRepository barberShopRepository;

    private final ServiceMapper serviceMapper;

    public ServiceDto createService(ServiceDto serviceDto){

        BarbershopEntity barbershop = barberShopRepository.findById(serviceDto.barbershopId()).orElse(null);

        if (barbershop == null){
            throw new RuntimeException("Barbershop not found");
        }

        ServiceEntity service = serviceMapper.toServiceEntity(serviceDto);

        service.setBarbershop(barbershop);

        ServiceEntity savedService = serviceRepository.save(service);

        return serviceMapper.toServiceDto(savedService);
    }

    public List<ServiceDto> getAllService(){
        List<ServiceEntity> serviceList = serviceRepository.findAll();
        List<ServiceDto> serviceDtoList = new ArrayList<>();

        for (ServiceEntity service : serviceList) {

            ServiceDto serviceDto= serviceMapper.toServiceDto(service);

            serviceDtoList.add(serviceDto);
        }
        return serviceDtoList;
    }

    public ServiceDto getSeviceById(Long serviceId){

        ServiceEntity service = serviceRepository.findById(serviceId).orElse(null);

        if (service == null){
            throw  new RuntimeException("Service not found");
        }

        ServiceDto serviceDto = serviceMapper.toServiceDto(service);

        return serviceDto;
    }

    public ServiceDto updateServiceById(ServiceDto serviceDto, Long serviceId){

        ServiceEntity service = serviceRepository.findById(serviceId).orElse(null);

        if (service == null){
            throw  new RuntimeException("Service not found");
        }

        service.setName(serviceDto.name());
        service.setPrice(serviceDto.price());
        service.setDuration(serviceDto.duration());

        serviceRepository.save(service);

        return serviceMapper.toServiceDto(service);
    }


    public void deleteServiceById( Long serviceId ){

        ServiceEntity service = serviceRepository.findById(serviceId).orElse(null);

        if (service == null){

            throw  new RuntimeException("Barber not found");

        }

        serviceRepository.delete(service);
    }
}
