package com.sector.service.sectorservice.infrastructure.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaDTO;

@Mapper(componentModel = "spring")
public interface ComunaMapper {
    ComunaMapper INSTANCE = Mappers.getMapper(ComunaMapper.class);
    
    ComunaDTO toDTO(Comuna comuna);
    
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "barrios", ignore = true)
    Comuna toDomain(ComunaDTO comunaDTO);
}
