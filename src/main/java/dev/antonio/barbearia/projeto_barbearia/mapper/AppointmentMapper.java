package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.AppointmentDto;
import dev.antonio.barbearia.projeto_barbearia.entities.AppointmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper {

    @Mapping(target = "barbershop", ignore = true)
    @Mapping(target = "service", ignore = true)
    @Mapping(target = "barber", ignore = true)
    @Mapping(target = "customer", ignore = true)
    AppointmentEntity toAppointmentEntity(AppointmentDto appointmentDto);


    @Mapping(target = "barbershopId", source = "barbershop.id")
    @Mapping(target = "serviceId", source = "service.id")
    @Mapping(target = "barberId", source = "barber.id")
    @Mapping(target = "customerId", source = "customer.id")
    AppointmentDto toAppointmentDto(AppointmentEntity appointmentEntity);

}
