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

    /**
     * Retrieves a Comuna object by its ID.
     *
     * @param id the ID of the Comuna object to retrieve
     * @return an Optional containing the retrieved Comuna object, or an empty
     *         Optional if no Comuna object is found
     */
    @Override
    public Optional<Comuna> getById(Long id) {
        return comunaRepository.findById(id);
    }

    /**
     * Retrieves all the "Comuna" objects from the database.
     *
     * @return a list of "Comuna" objects
     */
    @Override
    public List<Comuna> getAll() {
        return comunaRepository.findAll();
    }

}
