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

    /**
     * Retrieves a Barrio object by its ID.
     *
     * @param id the ID of the Barrio object to retrieve
     * @return an Optional containing the Barrio object if found, or an empty
     *         Optional if not found
     */
    @Override
    public Optional<Barrio> getById(Long id) {
        return barrioRepository.findById(id);
    }

    /**
     * Retrieves all the Barrio objects.
     *
     * @return a list of all the Barrio objects
     */
    @Override
    public List<Barrio> getAll() {
        return barrioRepository.findAll();
    }

    /**
     * Retrieves a list of Barrio objects based on the given comuna ID.
     *
     * @param comunaId the ID of the comuna to filter the barrios by
     * @return a list of Barrio objects that belong to the specified comuna
     */
    @Override
    public List<Barrio> getByComunaId(Long comunaId) {
        return barrioRepository.findByComunaId(comunaId);
    }

}
