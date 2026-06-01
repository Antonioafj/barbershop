package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.BarberShopDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarbershopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BarberShopMapper {

    BarbershopEntity toBarbershopEntity(BarberShopDto barberShopDto);

    BarberShopDto toBarberShopDto(BarbershopEntity barbershopEntity);

}
