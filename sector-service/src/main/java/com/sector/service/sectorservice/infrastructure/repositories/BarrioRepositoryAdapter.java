package com.sector.service.sectorservice.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.port.out.persistence.IBarrioRepositoryPort;
import com.sector.service.sectorservice.infrastructure.entities.BarrioEntity;

@Component
public class BarrioRepositoryAdapter implements IBarrioRepositoryPort {

    private final BarrioRepository barrioRepository;

    public BarrioRepositoryAdapter(BarrioRepository barrioRepository) {
        this.barrioRepository = barrioRepository;
    }

    /**
     * Saves a Barrio model.
     *
     * @param model the Barrio model to be saved
     * @return the saved Barrio model
     */
    @Override
    public Barrio save(Barrio model) {
        BarrioEntity barrioEntity = BarrioEntity.fromDomainModel(model);
        BarrioEntity savedBarrioEntity = barrioRepository.save(barrioEntity);
        return savedBarrioEntity.toDomainModel();
    }

    /**
     * Retrieves a Barrio object by its ID.
     *
     * @param id the ID of the Barrio object to retrieve
     * @return an Optional containing the Barrio object with the given ID, or an
     *         empty Optional if no such Barrio exists
     */
    @Override
    public Optional<Barrio> findById(Long id) {
        return barrioRepository.findById(id).map(BarrioEntity::toDomainModel);
    }

    /**
     * Retrieves all instances of the `Barrio` class from the database.
     *
     * @return a list of `Barrio` objects representing the retrieved instances
     */
    @Override
    public List<Barrio> findAll() {
        return barrioRepository.findAll().stream().map(BarrioEntity::toDomainModel).toList();
    }

    /**
     * Updates a Barrio object in the database.
     *
     * @param model the Barrio object to be updated
     * @return an Optional containing the updated Barrio object if the update was
     *         successful, otherwise an empty Optional
     */
    @Override
    public Optional<Barrio> update(Barrio model) {
        if (barrioRepository.existsById(model.getId())) {
            BarrioEntity barrioEntity = BarrioEntity.fromDomainModel(model);
            BarrioEntity savedBarrioEntity = barrioRepository.save(barrioEntity);
            return Optional.of(savedBarrioEntity.toDomainModel());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     * @return true if the entity was deleted, false otherwise
     */
    @Override
    public boolean deleteById(Long id) {
        if (barrioRepository.existsById(id)) {
            barrioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Barrio> findByComunaId(Long comunaId) {
        return barrioRepository.findByComunaId(comunaId).stream().map(BarrioEntity::toDomainModel).toList();
    }

}
