package com.sector.service.sectorservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sector.service.sectorservice.application.services.SectorService;
import com.sector.service.sectorservice.application.usecases.CreateBarrioUseCaseImpl;
import com.sector.service.sectorservice.application.usecases.CreateComunaUseCaseImpl;
import com.sector.service.sectorservice.application.usecases.RetrieveBarrioUseCaseImpl;
import com.sector.service.sectorservice.application.usecases.RetrieveComunaUseCaseImpl;
import com.sector.service.sectorservice.domain.ports.out.BarrioPersistencePort;
import com.sector.service.sectorservice.domain.ports.out.ComunaPersistencePort;
import com.sector.service.sectorservice.infrastructure.repositories.BarrioRepositoryAdapter;
import com.sector.service.sectorservice.infrastructure.repositories.ComunaRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public SectorService sectorService(ComunaPersistencePort comunaPersistencePort, BarrioPersistencePort barrioPersistencePort) {
        return new SectorService(
            new CreateBarrioUseCaseImpl(barrioPersistencePort),
            new CreateComunaUseCaseImpl(comunaPersistencePort),
            new RetrieveBarrioUseCaseImpl(barrioPersistencePort),
            new RetrieveComunaUseCaseImpl(comunaPersistencePort)
        );
    }

    @Bean
    public ComunaPersistencePort comunaPersistencePort(ComunaRepositoryAdapter comunaRepositoryAdapter) {
        return comunaRepositoryAdapter;
    }

    @Bean
    public BarrioPersistencePort barrioPersistencePort(BarrioRepositoryAdapter barrioRepositoryAdapter) {
        return barrioRepositoryAdapter;
    }
}
