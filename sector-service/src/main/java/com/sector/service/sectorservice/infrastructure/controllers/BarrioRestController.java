package com.sector.service.sectorservice.infrastructure.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sector.service.sectorservice.application.services.IBarrioService;
import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.port.in.web.IBarrioWebPort;
import com.sector.service.sectorservice.infrastructure.entities.dto.BarrioDTO;
import com.sector.service.sectorservice.infrastructure.entities.mapper.BarrioMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Barrios", description = "Endpoint para el manejo de los barrios de la ciudad de Montería")
public class BarrioRestController implements IBarrioWebPort {

    private final IBarrioService barrioService;
    private final BarrioMapper barrioMapper ;

    public BarrioRestController(IBarrioService barrioService, BarrioMapper barrioMapper) {
        this.barrioService = barrioService;
        this.barrioMapper = barrioMapper;
    }

    @Override
    @GetMapping("/barrios")
    public ResponseEntity<List<BarrioDTO>> list() {
            List<Barrio> barrios = barrioService.getAll();
        if (barrios.isEmpty()) return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(barrios.stream().map(barrioMapper::toDTO).toList());
    }

    @Override
    @GetMapping("/barrios/{id}")
    public ResponseEntity<BarrioDTO> getById(Long id) {
        BarrioDTO barrio = barrioService.getById(id).map(barrioMapper::toDTO).orElse(null);
        if (barrio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(barrio);
    }

}
