package com.sector.service.sectorservice.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sector.service.sectorservice.infrastructure.entities.BarrioEntity;

@Repository
public interface BarrioRepository extends JpaRepository<BarrioEntity, Long> {
    @Query("SELECT b FROM BarrioEntity b WHERE b.comuna.id = :comunaId")
    List<BarrioEntity> findByComunaId(Long comunaId);
}
