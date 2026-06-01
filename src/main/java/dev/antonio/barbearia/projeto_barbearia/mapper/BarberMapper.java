package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.BarberDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BarberMapper {

    @Mapping(target = "barbershop", ignore = true)
    BarberEntity toBarberEntity(BarberDto barberDto);

    @Mapping(target = "barbershopId", source = "barbershop.id")
    BarberDto toBarberDto(BarberEntity barberEntity);

}
