package com.sector.service.sectorservice.domain.port.out.persistence;

import java.util.List;

import com.sector.service.sectorservice.domain.Barrio;

public interface IBarrioRepositoryPort extends IRepositoryPort<Barrio, Long> {

    List<Barrio> findByComunaId(Long comunaId);
}
