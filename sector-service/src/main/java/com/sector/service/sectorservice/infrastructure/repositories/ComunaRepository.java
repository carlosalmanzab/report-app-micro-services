package com.sector.service.sectorservice.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sector.service.sectorservice.infrastructure.entities.ComunaEntity;

@Repository
public interface ComunaRepository extends JpaRepository<ComunaEntity, Long> {

}
