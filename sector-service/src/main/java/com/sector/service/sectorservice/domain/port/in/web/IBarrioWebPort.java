package com.sector.service.sectorservice.domain.port.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sector.service.sectorservice.infrastructure.entities.dto.BarrioDTO;

public interface IBarrioWebPort {

    /**
     * Retrieves a list of barrios.
     *
     * @return a ResponseEntity containing a list of BarrioDTO objects
     */
    @GetMapping("/barrios")
    ResponseEntity<List<BarrioDTO>> list();

    /**
     * Retrieves a `BarrioDTO` by its ID.
     *
     * @param id the ID of the `Barrio` to retrieve
     * @return a `ResponseEntity` containing the `BarrioDTO`, or an empty response
     *         if not found
     */
    @GetMapping("/barrios/{id}")
    ResponseEntity<BarrioDTO> getById(@PathVariable Long id);

    /**
     * Retrieves a list of BarrioDTO objects by the given Comuna ID.
     *
     * @param id the ID of the Comuna
     * @return a ResponseEntity containing a list of BarrioDTO objects
     */
    @GetMapping("/Comunas/{id}/barrios")
    ResponseEntity<List<BarrioDTO>> listByComunaId(@PathVariable Long id);
}
