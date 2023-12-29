package com.sector.service.sectorservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sector.service.sectorservice.application.services.BarrioServiceImpl;
import com.sector.service.sectorservice.application.services.ComunaFacadeServiceImpl;
import com.sector.service.sectorservice.application.services.ComunaServiceImpl;
import com.sector.service.sectorservice.application.services.IBarrioService;
import com.sector.service.sectorservice.application.services.IComunaFacadeService;
import com.sector.service.sectorservice.application.services.IComunaService;
import com.sector.service.sectorservice.domain.port.out.persistence.IBarrioRepositoryPort;
import com.sector.service.sectorservice.domain.port.out.persistence.IComunaRepositoryPort;
import com.sector.service.sectorservice.infrastructure.repositories.BarrioRepositoryAdapter;
import com.sector.service.sectorservice.infrastructure.repositories.ComunaRepositoryAdapter;

@Configuration
public class ApplicationConfig {

        /**
     * Creates and returns an instance of the IComunaFacadeService interface.
     *
     * @param  comunaRepositoryPort  the repository port for the Comuna entity
     * @param  barrioRepositoryPort  the repository port for the Barrio entity
     * @return                       an instance of the ComunaFacadeServiceImpl class
     */
    @Bean
    public IComunaFacadeService comunaFacadeService(IComunaRepositoryPort comunaRepositoryPort, IBarrioRepositoryPort barrioRepositoryPort) {
        return new ComunaFacadeServiceImpl(
            new ComunaServiceImpl(comunaRepositoryPort),
            new BarrioServiceImpl(barrioRepositoryPort)
        );
    }

    /**
     * Creates and returns an instance of the IComunaService interface.
     *
     * @param comunaRepositoryPort the repository port for the Comuna entity
     * @return an instance of the ComunaServiceImpl class
     */
    @Bean
    public IComunaService comunaService(IComunaRepositoryPort comunaRepositoryPort) {
        return new ComunaServiceImpl(comunaRepositoryPort);
    }

    /**
     * Create a new instance of the `IBarrioService` interface.
     *
     * @param barrioRepositoryPort the `IBarrioRepositoryPort` implementation
     * @return the newly created `IBarrioService` instance
     */
    @Bean
    public IBarrioService barrioService(IBarrioRepositoryPort barrioRepositoryPort) {
        return new BarrioServiceImpl(barrioRepositoryPort);
    }

    /**
     * Creates a bean for the ComunaRepositoryPort interface.
     *
     * @param comunaRepositoryAdapter the ComunaRepositoryAdapter implementation
     * @return the ComunaRepositoryAdapter instance
     */
    @Bean
    public IComunaRepositoryPort comunaRepositoryPort(ComunaRepositoryAdapter comunaRepositoryAdapter) {
        return comunaRepositoryAdapter;
    }

    /**
     * Creates a bean for the BarrioRepositoryPort interface.
     *
     * @param barrioRepositoryAdapter the BarrioRepositoryAdapter to be used
     * @return the instance of BarrioRepositoryAdapter as a BarrioRepositoryPort
     */
    @Bean
    public IBarrioRepositoryPort barrioRepositoryPort(BarrioRepositoryAdapter barrioRepositoryAdapter) {
        return barrioRepositoryAdapter;
    }
}
