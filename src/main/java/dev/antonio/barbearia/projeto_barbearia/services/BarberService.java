package dev.antonio.barbearia.projeto_barbearia.services;

import dev.antonio.barbearia.projeto_barbearia.dtos.BarberDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarberEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import dev.antonio.barbearia.projeto_barbearia.mapper.BarberMapper;
import dev.antonio.barbearia.projeto_barbearia.repositories.BarberRepository;
import dev.antonio.barbearia.projeto_barbearia.repositories.BarberShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberService {

    private final BarberRepository barberRepository;

    private final BarberShopRepository barberShopRepository;

    private final BarberMapper barberMapper;

    public BarberDto createBarber(BarberDto barberDto){

        BarbershopEntity barbershop = barberShopRepository.findById(barberDto.barbershopId()).orElse(null);

        if (barbershop == null){
            throw new RuntimeException("Barbershop not found");
        }

        BarberEntity barber = barberMapper.toBarberEntity(barberDto);

        barber.setBarbershop(barbershop);

        BarberEntity savedBarber = barberRepository.save(barber);

        return barberMapper.toBarberDto(savedBarber);
    }

    public List<BarberDto> listAllBarber(){
        List<BarberEntity> barberList = barberRepository.findAll();
        List<BarberDto> barberDtoList = new ArrayList<>();

        for (BarberEntity barber : barberList) {

            BarberDto barberDto= barberMapper.toBarberDto(barber);

            barberDtoList.add(barberDto);
        }
        return barberDtoList;
    }

    public BarberDto getBarberById(Long barberId){

        BarberEntity barber = barberRepository.findById(barberId).orElse(null);

        if (barber == null){
            throw  new RuntimeException("Barber not found");
        }

        BarberDto barberDto = barberMapper.toBarberDto(barber);

        return barberDto;
    }

    public BarberDto updateBarberById(BarberDto barberDto, Long barberId){

        BarberEntity barber = barberRepository.findById(barberId).orElse(null);

        if (barber == null){
            throw  new RuntimeException("Barber not found");
        }

        barber.setName(barberDto.name());
        barber.setTelephone(barberDto.telephone());
        barber.setEmail(barberDto.email());

        barberRepository.save(barber);

        return barberMapper.toBarberDto(barber);
    }


    public void deleteBarberById( Long barberId ){

        BarberEntity barber = barberRepository.findById(barberId).orElse(null);

        if (barber == null){

            throw  new RuntimeException("Barber not found");

        }

        barberRepository.delete(barber);
    }
}





























