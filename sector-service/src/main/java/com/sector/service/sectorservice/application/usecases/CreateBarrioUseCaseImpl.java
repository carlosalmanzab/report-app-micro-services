package com.sector.service.sectorservice.application.usecases;

import com.sector.service.sectorservice.domain.models.Barrio;
import com.sector.service.sectorservice.domain.ports.in.CreateBarrioUseCase;
import com.sector.service.sectorservice.domain.ports.out.BarrioPersistencePort;

public class CreateBarrioUseCaseImpl implements CreateBarrioUseCase {

    private final BarrioPersistencePort barrioPersistencePort;

    public CreateBarrioUseCaseImpl(BarrioPersistencePort barrioRepositoryPort) {
        this.barrioPersistencePort = barrioRepositoryPort;
    }

    /**
     * Creates a new Barrio object and saves it.
     *
     * @param barrio the Barrio object to be saved
     * @return the saved Barrio object
     */
    @Override
    public Barrio createBarrio(Barrio barrio) {
        return barrioPersistencePort.save(barrio);
    }

}
