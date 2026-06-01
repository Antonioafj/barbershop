package dev.antonio.barbearia.projeto_barbearia.mapper;

import dev.antonio.barbearia.projeto_barbearia.dtos.ServiceDto;
import dev.antonio.barbearia.projeto_barbearia.entities.ServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceMapper {

    ServiceEntity toServiceEntity(ServiceDto serviceDto);

    ServiceDto toServiceDto(ServiceEntity serviceEntity);

}
