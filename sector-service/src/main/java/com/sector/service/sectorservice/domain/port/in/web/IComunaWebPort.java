package com.sector.service.sectorservice.domain.port.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaDTO;

public interface IComunaWebPort {

    /**
     * Retrieves a list of ComunaDTO objects.
     *
     * @return A ResponseEntity containing a list of ComunaDTO objects
     */
    @GetMapping("/comunas")
    ResponseEntity<List<ComunaDTO>> list();

    /**
     * Retrieves a ComunaDTO by its ID.
     *
     * @param id the ID of the Comuna
     * @return the ComunaDTO with the specified ID
     */
    @GetMapping("/comunas/{id}")
    ResponseEntity<ComunaDTO> getById(@PathVariable Long id);
}
