package com.sector.service.sectorservice.application.services;

import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.Comuna;

public class ComunaFacade {
    private final ComunaServiceImpl comunaService;
    private final BarrioServiceImpl barrioService;

    public ComunaFacade(ComunaServiceImpl comunaService, BarrioServiceImpl barrioService) {
        this.comunaService = comunaService;
        this.barrioService = barrioService;
    }

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

    public Optional<Comuna> getComunaByIdWithBarrios(Long id) {
        Optional<Comuna> comuna = comunaService.getById(id);
        if (comuna.isEmpty())
            return comuna;

        comuna.get().setBarrios(barrioService.getByComunaId(id));

        return comuna;
    }
}
