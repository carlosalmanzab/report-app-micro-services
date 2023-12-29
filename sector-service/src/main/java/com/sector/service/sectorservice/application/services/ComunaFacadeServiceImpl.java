package com.sector.service.sectorservice.application.services;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.Comuna;

public class ComunaFacadeServiceImpl implements IComunaFacadeService {
    private final ComunaServiceImpl comunaService;
    private final BarrioServiceImpl barrioService;

    public ComunaFacadeServiceImpl(ComunaServiceImpl comunaService, BarrioServiceImpl barrioService) {
        this.comunaService = comunaService;
        this.barrioService = barrioService;
    }

    /**
     * Retrieves a list of all Comunas along with their associated Barrios.
     *
     * @return A list of Comuna objects with their associated Barrios.
     */
    @Override
    public List<Comuna> getAllComunasWithBarrios() {
        List<Comuna> comunas = comunaService.getAll();
        if (comunas.isEmpty())
            return comunas;

        comunas.forEach(c -> {
            List<Barrio> barrios = barrioService.getByComunaId(c.getId());
            if (!barrios.isEmpty())
                c.setBarrios(barrios);
        });

        return comunas;
    }

    /**
     * Retrieves a Comuna by its ID along with its associated Barrios.
     *
     * @param id the ID of the Comuna to retrieve
     * @return an Optional containing the Comuna if found, otherwise an empty
     *         Optional
     */
    @Override
    public Optional<Comuna> getComunaByIdWithBarrios(Long id) {
        Optional<Comuna> comuna = comunaService.getById(id);
        if (comuna.isEmpty())
            return comuna;

        comuna.get().setBarrios(barrioService.getByComunaId(id));

        return comuna;
    }
}
