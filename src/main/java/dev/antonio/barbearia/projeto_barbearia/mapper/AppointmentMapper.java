package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.AppointmentDto;
import dev.antonio.barbearia.projeto_barbearia.entities.AppointmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper {

    AppointmentEntity toAppointmentEntity(AppointmentDto appointmentDto);

    AppointmentDto toAppointmentDto(AppointmentEntity appointmentEntity);

}
