package com.sector.service.sectorservice.application.services;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.port.out.persistence.IBarrioRepositoryPort;

public class BarrioServiceImpl implements IBarrioService {

    private final IBarrioRepositoryPort barrioRepository;

    public BarrioServiceImpl(IBarrioRepositoryPort barrioRepository) {
        this.barrioRepository = barrioRepository;
    }

    @Override
    public Optional<Barrio> getById(Long id) {
        return barrioRepository.findById(id);
    }

    @Override
    public List<Barrio> getAll() {
        return barrioRepository.findAll();
    }

    @Override
    public List<Barrio> getByComunaId(Long comunaId) {
        return barrioRepository.findByComunaId(comunaId);
    }


}
