package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.CustomerDto;
import dev.antonio.barbearia.projeto_barbearia.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustumerMapper {

    @Mapping(target = "barbershop", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    @Mapping(target = "barbershopId", source = "barbershop.id")
    CustomerDto toCustomerDto(CustomerEntity customerEntity);

}
