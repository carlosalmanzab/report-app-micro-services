package com.sector.service.sectorservice.application.usecases;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.models.Barrio;
import com.sector.service.sectorservice.domain.models.Comuna;
import com.sector.service.sectorservice.domain.ports.in.RetrieveBarrioUseCase;
import com.sector.service.sectorservice.domain.ports.out.BarrioPersistencePort;

public class RetrieveBarrioUseCaseImpl implements RetrieveBarrioUseCase {

    private final BarrioPersistencePort barrioPersistencePort;

    public RetrieveBarrioUseCaseImpl(BarrioPersistencePort barrioRepositoryPort) {
        this.barrioPersistencePort = barrioRepositoryPort;
    }

    /**
     * Retrieves a Barrio by its ID.
     *
     * @param id the ID of the Barrio to retrieve
     * @return an Optional containing the Barrio, or an empty Optional if no Barrio
     *         exists with the given ID
     */
    @Override
    public Optional<Barrio> getBarrioById(Long id) {
        return barrioPersistencePort.findById(id);
    }

    /**
     * Retrieves all barrios.
     *
     * @return a list of all barrios
     */
    @Override
    public List<Barrio> getAllBarrios() {
        return barrioPersistencePort.findAll();
    }

        /**
     * Find Barrios by Comuna Id.
     *
     * @param  comunaId  the id of the Comuna
     * @return           a list of Barrios
     */
    @Override
    public List<Barrio> getBarriosByComunaId(Long comunaId) {
        return barrioPersistencePort.findByComunaId(comunaId);
    }
}
