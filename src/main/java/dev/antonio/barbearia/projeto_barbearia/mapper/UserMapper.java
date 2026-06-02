package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.BarberDto;
import dev.antonio.barbearia.projeto_barbearia.dtos.UserDto;
import dev.antonio.barbearia.projeto_barbearia.entities.BarberEntity;
import dev.antonio.barbearia.projeto_barbearia.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "barbershop", ignore = true)
    UserEntity toUserEntity(UserDto userDtoDto);

    @Mapping(target = "barbershopId", source = "barbershop.id")
    UserDto toUserDto(UserEntity userEntity);

}
