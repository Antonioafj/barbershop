package dev.antonio.barbearia.projeto_barbearia.services;

import dev.antonio.barbearia.projeto_barbearia.dtos.AppointmentDto;
import dev.antonio.barbearia.projeto_barbearia.entities.*;
import dev.antonio.barbearia.projeto_barbearia.enums.AppointmentStatus;
import dev.antonio.barbearia.projeto_barbearia.mapper.AppointmentMapper;
import dev.antonio.barbearia.projeto_barbearia.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final BarberShopRepository barberShopRepository;

    private final AppointmentMapper appointmentMapper;

    private final CustomerRepository customerRepository;

    private final BarberRepository barberRepository;

    private final ServiceRepository serviceRepository;

    public AppointmentDto createAppointment(AppointmentDto appointmentDto){

        BarbershopEntity barbershop = barberShopRepository.findById(appointmentDto.barbershopId()).orElse(null);
        CustomerEntity customer  = customerRepository.findById(appointmentDto.customerId()).orElse(null);
        BarberEntity barber = barberRepository.findById(appointmentDto.barberId()).orElse(null);
        ServiceEntity  service = serviceRepository.findById(appointmentDto.serviceId()).orElse(null);


        if (barbershop == null){
            throw new RuntimeException("Barbershop not found");
        } else if (customer == null){
            throw new RuntimeException("Customer not found");
        }else if (barber == null){
            throw new RuntimeException("Barber not found");
        }else if (service == null){
            throw new RuntimeException("Service not found");
        }

        AppointmentEntity appointment = appointmentMapper.toAppointmentEntity(appointmentDto);

        appointment.setBarbershop(barbershop);
        appointment.setCustomer(customer);
        appointment.setBarber(barber);
        appointment.setService(service);
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        AppointmentEntity savedAppointment = appointmentRepository.save(appointment);

        return appointmentMapper.toAppointmentDto(savedAppointment);
    }

    public List<AppointmentDto> getAllAppointment(){
        List<AppointmentEntity> appointmentList = appointmentRepository.findAll();
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();

        for (AppointmentEntity appointment : appointmentList) {

            AppointmentDto appointmentDto = appointmentMapper.toAppointmentDto(appointment);

            appointmentDtoList.add(appointmentDto);
        }
        return appointmentDtoList;
    }

    public AppointmentDto getAppointmentById(Long appointmentId){

        AppointmentEntity appointment = appointmentRepository.findById(appointmentId).orElse(null);

        if (appointment == null){
            throw  new RuntimeException("Customer not found");
        }

        AppointmentDto appointmentDto = appointmentMapper.toAppointmentDto(appointment);

        return appointmentDto;
    }

    public AppointmentDto updateAppointmentById(AppointmentDto appointmentDto, Long appointmentId){

        AppointmentEntity appointment = appointmentRepository.findById(appointmentId).orElse(null);

        if (appointment == null){
            throw new RuntimeException("Appointment not found");
        }

        BarberEntity barber = barberRepository.findById(appointmentDto.barberId()).orElse(null);
        ServiceEntity  service = serviceRepository.findById(appointmentDto.serviceId()).orElse(null);


         if (barber == null){
            throw new RuntimeException("Barber not found");
        }else if (service == null){
            throw new RuntimeException("Service not found");
        }

        appointment.setBarber(barber);
        appointment.setService(service);
        appointment.setStatus(appointmentDto.status());
        appointment.setAppointmentTime(appointmentDto.appointmentTime());

        AppointmentEntity savedAppointment = appointmentRepository.save(appointment);

        return appointmentMapper.toAppointmentDto(savedAppointment);
    }


    public void deleteAppointmentById( Long appointmentId ){

        AppointmentEntity appointment = appointmentRepository.findById(appointmentId).orElse(null);

        if (appointment == null){

            throw  new RuntimeException("Appointment not found");

        }

        appointmentRepository.delete(appointment);
    }
}
