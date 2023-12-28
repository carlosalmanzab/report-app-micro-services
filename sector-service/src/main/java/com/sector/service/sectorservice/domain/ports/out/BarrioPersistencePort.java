package com.sector.service.sectorservice.domain.ports.out;

import java.util.List;

import com.sector.service.sectorservice.domain.models.Barrio;

public interface BarrioPersistencePort extends GenericPersistence<Barrio, Long> {

    List<Barrio> findByComunaId(Long comunaId);
}
