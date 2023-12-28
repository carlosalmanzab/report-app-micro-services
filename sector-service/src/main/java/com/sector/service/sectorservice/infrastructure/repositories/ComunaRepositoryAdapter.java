package com.sector.service.sectorservice.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sector.service.sectorservice.domain.models.Comuna;
import com.sector.service.sectorservice.domain.ports.out.ComunaPersistencePort;
import com.sector.service.sectorservice.infrastructure.entities.ComunaEntity;

@Component
public class ComunaRepositoryAdapter implements ComunaPersistencePort {

    private final ComunaRepository comunaRepository;

    public ComunaRepositoryAdapter(ComunaRepository comunaRepository) {
        this.comunaRepository = comunaRepository;
    }

    /**
     * Saves a Comuna model.
     *
     * @param model the Comuna model to be saved
     * @return the saved Comuna model
     */
    @Override
    public Comuna save(Comuna model) {
        ComunaEntity comunaEntity = ComunaEntity.fromDomainModel(model);
        ComunaEntity savedComunaEntity = comunaRepository.save(comunaEntity);
        return savedComunaEntity.toDomainModel();
    }

    /**
     * Retrieves an Optional object containing a Comuna instance by its ID.
     *
     * @param id the ID of the Comuna instance to retrieve
     * @return an Optional object containing the retrieved Comuna instance
     */
    @Override
    public Optional<Comuna> findById(Long id) {
        return comunaRepository.findById(id).map(ComunaEntity::toDomainModel);
    }

    /**
     * Retrieves a list of all Comuna objects.
     *
     * @return a list of Comuna objects
     */
    @Override
    public List<Comuna> findAll() {
        return comunaRepository.findAll().stream().map(ComunaEntity::toDomainModel).toList();
    }

    /**
     * Updates a Comuna object in the repository.
     *
     * @param model the Comuna object to be updated
     * @return an Optional containing the updated Comuna object if it exists in the
     *         repository, or an empty Optional if it does not exist
     */
    @Override
    public Optional<Comuna> update(Comuna model) {
        if (comunaRepository.existsById(model.getId())) {
            ComunaEntity comunaEntity = ComunaEntity.fromDomainModel(model);
            ComunaEntity savedComunaEntity = comunaRepository.save(comunaEntity);
            return Optional.of(savedComunaEntity.toDomainModel());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to be deleted
     * @return true if the entity was deleted successfully, false otherwise
     */
    @Override
    public boolean deleteById(Long id) {
        if (comunaRepository.existsById(id)) {
            comunaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
