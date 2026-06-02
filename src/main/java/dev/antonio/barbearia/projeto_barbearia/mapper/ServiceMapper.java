package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.ServiceDto;
import dev.antonio.barbearia.projeto_barbearia.entities.ServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceMapper {

    @Mapping(target = "barbershop", ignore = true)
    ServiceEntity toServiceEntity(ServiceDto serviceDto);

    @Mapping(target = "barbershopId", source = "barbershop.id")
    ServiceDto toServiceDto(ServiceEntity serviceEntity);

}
