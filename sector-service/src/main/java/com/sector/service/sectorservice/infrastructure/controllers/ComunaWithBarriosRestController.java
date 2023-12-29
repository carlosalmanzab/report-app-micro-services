package com.sector.service.sectorservice.infrastructure.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sector.service.sectorservice.application.services.ComunaFacade;
import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.domain.port.in.web.IComunaWithBarriosWebPort;
import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaDTO;
import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaWithBarriosDTO;
import com.sector.service.sectorservice.infrastructure.entities.mapper.ComunaWithBarriosMapper;

@RestController
@RequestMapping("/api")
public class ComunaWithBarriosRestController implements IComunaWithBarriosWebPort {

    private final ComunaFacade comunaFacade;
    private final ComunaWithBarriosMapper comunaWithBarriosMapper;

    public ComunaWithBarriosRestController(ComunaFacade comunaFacade, ComunaWithBarriosMapper comunaWithBarriosMapper) {
        this.comunaFacade = comunaFacade;
        this.comunaWithBarriosMapper = comunaWithBarriosMapper;
    }

    @Override
    @GetMapping("/comunas/barrios")
    public ResponseEntity<List<ComunaWithBarriosDTO>> list() {
        List<Comuna> comunas = comunaFacade.getAllComunasWithBarrios();

        if (comunas.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(comunas.stream().map(comunaWithBarriosMapper::toDTO).toList());
    }

    @Override
    @GetMapping("/comunas/{id}/barrios")
    public ResponseEntity<ComunaWithBarriosDTO> getById(Long id) {
        ComunaWithBarriosDTO comuna = comunaFacade.getComunaByIdWithBarrios(id).map(comunaWithBarriosMapper::toDTO)
                .orElse(null);
        if (comuna == null  || comuna.getBarrios().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comuna);
    }

}
