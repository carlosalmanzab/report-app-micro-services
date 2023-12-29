package com.sector.service.sectorservice.infrastructure.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sector.service.sectorservice.application.services.IComunaFacadeService;
import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.domain.port.in.web.IComunaWithBarriosWebPort;
import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaWithBarriosDTO;
import com.sector.service.sectorservice.infrastructure.entities.mapper.ComunaWithBarriosMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Comunas Con Barrios", description = "Endpoint para el manejo de las comunas junto a sus barrios pertenecientes a la ciudad de Montería")
public class ComunaWithBarriosRestController implements IComunaWithBarriosWebPort {

    private final IComunaFacadeService comunaFacadeService;
    private final ComunaWithBarriosMapper comunaWithBarriosMapper;

    public ComunaWithBarriosRestController(IComunaFacadeService comunaFacadeService, ComunaWithBarriosMapper comunaWithBarriosMapper) {
        this.comunaFacadeService = comunaFacadeService;
        this.comunaWithBarriosMapper = comunaWithBarriosMapper;
    }

    @Override
    @GetMapping("/comunas/barrios")
    public ResponseEntity<List<ComunaWithBarriosDTO>> list() {
        List<Comuna> comunas = comunaFacadeService.getAllComunasWithBarrios();

        if (comunas.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(comunas.stream().map(comunaWithBarriosMapper::toDTO).toList());
    }

    @Override
    @GetMapping("/comunas/{id}/barrios")
    public ResponseEntity<ComunaWithBarriosDTO> getById(Long id) {
        ComunaWithBarriosDTO comuna = comunaFacadeService.getComunaByIdWithBarrios(id).map(comunaWithBarriosMapper::toDTO)
                .orElse(null);
        if (comuna == null  || comuna.getBarrios().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comuna);
    }

}
