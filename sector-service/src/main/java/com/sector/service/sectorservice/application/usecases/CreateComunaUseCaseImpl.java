package com.sector.service.sectorservice.application.usecases;

import com.sector.service.sectorservice.domain.models.Comuna;
import com.sector.service.sectorservice.domain.ports.in.CreateComunaUseCase;
import com.sector.service.sectorservice.domain.ports.out.ComunaPersistencePort;

public class CreateComunaUseCaseImpl implements CreateComunaUseCase {

    private final ComunaPersistencePort comunaPersistencePort;

    public CreateComunaUseCaseImpl(ComunaPersistencePort comunaRepositoryPort) {
        this.comunaPersistencePort = comunaRepositoryPort;
    }

    /**
     * Creates a new Comuna.
     *
     * @param comuna the Comuna object to be created
     * @return the created Comuna object
     */
    @Override
    public Comuna createComuna(Comuna comuna) {
        return comunaPersistencePort.save(comuna);
    }

}
