package com.sector.service.sectorservice.application.services;

import java.util.List;

import com.sector.service.sectorservice.domain.Barrio;

public interface IBarrioService extends IService<Barrio, Long> {
    List<Barrio> getByComunaId(Long comunaId);
}
