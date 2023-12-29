package com.sector.service.sectorservice.domain.port.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaWithBarriosDTO;

public interface IComunaWithBarriosWebPort {

        /**
     * Retrieves a list of comunas with their corresponding barrios.
     *
     * @return  A response entity containing a list of ComunaWithBarriosDTO objects.
     */
    @GetMapping("/comunas/barrios")
    ResponseEntity<List<ComunaWithBarriosDTO>> list();

        /**
     * Retrieves a ComunaWithBarriosDTO object by its ID.
     *
     * @param  id  the ID of the Comuna to retrieve
     * @return     a ResponseEntity containing the ComunaWithBarriosDTO object
     */
    @GetMapping("/comunas/{id}/barrios")
    ResponseEntity<ComunaWithBarriosDTO> getById(@PathVariable Long id);
}
