package com.sector.service.sectorservice.infrastructure.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sector.service.sectorservice.application.services.IBarrioService;
import com.sector.service.sectorservice.domain.port.in.web.IBarrioWebPort;
import com.sector.service.sectorservice.infrastructure.entities.dto.BarrioDTO;

@RestController
@RequestMapping("/api")
public class BarrioRestController implements IBarrioWebPort {

    private final IBarrioService barrioService;

    public BarrioRestController(IBarrioService barrioService) {
        this.barrioService = barrioService;
    }

    @Override
    public ResponseEntity<List<BarrioDTO>> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public ResponseEntity<BarrioDTO> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ResponseEntity<List<BarrioDTO>> listByComunaId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listByComunaId'");
    }

}
