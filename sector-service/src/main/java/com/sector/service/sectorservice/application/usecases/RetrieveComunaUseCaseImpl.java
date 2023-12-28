package com.sector.service.sectorservice.application.usecases;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.models.Comuna;
import com.sector.service.sectorservice.domain.ports.in.RetrieveComunaUseCase;
import com.sector.service.sectorservice.domain.ports.out.ComunaPersistencePort;

public class RetrieveComunaUseCaseImpl implements RetrieveComunaUseCase {

    private final ComunaPersistencePort comunaPersistencePort;

    public RetrieveComunaUseCaseImpl(ComunaPersistencePort comunaRepositoryPort) {
        this.comunaPersistencePort = comunaRepositoryPort;
    }

    /**
     * Retrieves a Comuna object by its ID.
     *
     * @param id the ID of the Comuna object to retrieve
     * @return an Optional containing the Comuna object if found, or an empty
     *         Optional if not found
     */
    @Override
    public Optional<Comuna> getComunaById(Long id) {
        return comunaPersistencePort.findById(id);
    }

    /**
     * Retrieves a list of all Comuna objects.
     *
     * @return a list of Comuna objects
     */
    @Override
    public List<Comuna> getAllComunas() {
        return comunaPersistencePort.findAll();
    }

}
