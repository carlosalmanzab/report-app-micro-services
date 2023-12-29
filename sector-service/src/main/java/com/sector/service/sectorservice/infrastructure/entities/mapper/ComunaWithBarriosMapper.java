package com.sector.service.sectorservice.infrastructure.entities.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.infrastructure.entities.dto.BarrioDTO;
import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaWithBarriosDTO;

@Mapper(componentModel = "spring")
public interface ComunaWithBarriosMapper {
    ComunaWithBarriosMapper INSTANCE = Mappers.getMapper(ComunaWithBarriosMapper.class);

    ComunaWithBarriosDTO toDTO(Comuna comuna);
    
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "barrios", source = "barrios", qualifiedByName = "barrioMapper")
    Comuna toDomain(ComunaWithBarriosDTO comunaDTO);

    List<Barrio> map(List<BarrioDTO> barrios);

    @Named("barrioMapper")
    @Mapping(target = "fechaCreacion", ignore = true)
    Barrio toBarrio(BarrioDTO barrioDTO);
}
