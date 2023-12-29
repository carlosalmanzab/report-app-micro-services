package com.sector.service.sectorservice.infrastructure.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.infrastructure.entities.dto.BarrioDTO;

@Mapper(componentModel = "spring")
public interface BarrioMapper {

    BarrioMapper INSTANCE = Mappers.getMapper(BarrioMapper.class);

    BarrioDTO toDTO(Barrio barrio);

    @Mapping(target = "fechaCreacion", ignore = true)
    Barrio toDomain(BarrioDTO barrioDTO);
}
