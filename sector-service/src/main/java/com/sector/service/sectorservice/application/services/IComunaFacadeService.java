package com.sector.service.sectorservice.application.services;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.Comuna;

public interface IComunaFacadeService {
    public List<Comuna> getAllComunasWithBarrios();
    public Optional<Comuna> getComunaByIdWithBarrios(Long id);
}
