package com.sector.service.sectorservice.infrastructure.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sector.service.sectorservice.application.services.IComunaService;
import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.domain.port.in.web.IComunaWebPort;
import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaDTO;
import com.sector.service.sectorservice.infrastructure.entities.mapper.ComunaMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Comunas", description = "Endpoint para el manejo de las comunas de la ciudad de Montería")
public class ComunaRestController implements IComunaWebPort {

    private final IComunaService comunaService;
    private final ComunaMapper comunaMapper;

    public ComunaRestController(IComunaService comunaService, ComunaMapper comunaMapper) {
        this.comunaService = comunaService;
        this.comunaMapper = comunaMapper;
    }

    @Override
    @GetMapping("/comunas")
    public ResponseEntity<List<ComunaDTO>> list() {
        List<Comuna> comunas = comunaService.getAll();

        if (comunas.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(comunas.stream().map(comunaMapper::toDTO).toList());
    }

    @Override
    @GetMapping("/comunas/{id}")
    public ResponseEntity<ComunaDTO> getById(Long id) {
        ComunaDTO comuna = comunaService.getById(id).map(comunaMapper::toDTO).orElse(null);
        if (comuna == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comuna);
    }

}
