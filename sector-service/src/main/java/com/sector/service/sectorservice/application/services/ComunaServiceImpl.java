package com.sector.service.sectorservice.application.services;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.domain.port.out.persistence.IComunaRepositoryPort;

public class ComunaServiceImpl implements IComunaService {

    private final IComunaRepositoryPort comunaRepository;

    public ComunaServiceImpl(IComunaRepositoryPort comunaRepository) {
        this.comunaRepository = comunaRepository;
    }

    @Override
    public Optional<Comuna> getById(Long id) {
        return comunaRepository.findById(id);
    }

    @Override
    public List<Comuna> getAll() {
        return comunaRepository.findAll();
    }


}
