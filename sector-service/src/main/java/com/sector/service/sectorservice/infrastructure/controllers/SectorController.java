package com.sector.service.sectorservice.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sector.service.sectorservice.application.services.SectorService;
import com.sector.service.sectorservice.domain.models.Barrio;
import com.sector.service.sectorservice.domain.models.Comuna;
import com.sector.service.sectorservice.infrastructure.entities.dto.BarrioDTO;
import com.sector.service.sectorservice.infrastructure.entities.dto.ComunaDTO;
import com.sector.service.sectorservice.infrastructure.entities.mapper.BarrioMapper;
import com.sector.service.sectorservice.infrastructure.entities.mapper.ComunaMapper;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/sectors")
@Tag(name = "Sectores", description = "Endpoint para el manejo de los sectores de la ciudad de Montería")
public class SectorController {

    private final SectorService sectorService;
    private final ComunaMapper comunaMapper;
    private final BarrioMapper barrioMapper;

    public SectorController(SectorService sectorService, ComunaMapper comunaMapper, BarrioMapper barrioMapper) {
        this.sectorService = sectorService;
        this.comunaMapper = comunaMapper;
        this.barrioMapper = barrioMapper;
    }

    /**
     * Retrieves all the Comunas.
     *
     * @return ResponseEntity<List<ComunaDTO>> - a response entity containing a list
     *         of ComunaDTO objects
     */
    @GetMapping("/Comunas")
    public ResponseEntity<List<ComunaDTO>> getAllComunas() {
        List<Comuna> comunas = sectorService.getAllComunas();

        if (comunas.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(comunas.stream().map(comunaMapper::toDTO).toList());
    }

    /**
     * Retrieves all barrios from the Comunas endpoint.
     *
     * @return ResponseEntity containing a list of BarrioDTO objects
     */
    @GetMapping("/Comunas/barrios")
    public ResponseEntity<List<BarrioDTO>> getAllBarrios() {
        List<Barrio> barrios = sectorService.getAllBarrios();
        if (barrios.isEmpty()) return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(barrios.stream().map(barrioMapper::toDTO).toList());
    }

    /**
     * Retrieves a ComunaDTO object by its id.
     *
     * @param id the id of the ComunaDTO object to retrieve
     * @return a ResponseEntity containing the retrieved ComunaDTO object, or a not
     *         found response if the ComunaDTO object does not exist
     */
    @GetMapping("/Comunas/{id}")
    public ResponseEntity<ComunaDTO> getComunaById(Long id) {
        ComunaDTO comuna = sectorService.getComunaById(id).map(comunaMapper::toDTO).orElse(null);
        if (comuna == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comuna);
    }

    /**
     * Retrieves a BarrioDTO by its ID.
     *
     * @param id the ID of the BarrioDTO
     * @return the ResponseEntity containing the BarrioDTO if found, or a 404 not
     *         found response
     */
    @GetMapping("/Comunas/barrios/{id}")
    public ResponseEntity<BarrioDTO> getBarrioById(Long id) {
        BarrioDTO barrio = sectorService.getBarrioById(id).map(barrioMapper::toDTO).orElse(null);
        if (barrio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(barrio);
    }

    /**
     * Creates a new Comuna using the provided ComunaDTO.
     *
     * @param comunaDTO the ComunaDTO object containing the data for the new Comuna
     * @return the ResponseEntity with the created ComunaDTO
     */
    @PostMapping("/Comunas")
    public ResponseEntity<ComunaDTO> createComuna(@RequestBody ComunaDTO comunaDTO) {
        Comuna comuna = comunaMapper.toDomain(comunaDTO);
        Comuna createdComuna = sectorService.createComuna(comuna);
        ComunaDTO createdComunaDTO = comunaMapper.toDTO(createdComuna);
        return ResponseEntity.ok(createdComunaDTO);
    }

    /**
     * Creates a new Barrio using the provided BarrioDTO.
     *
     * @param barrioDTO the BarrioDTO object containing the details of the new
     *                  Barrio
     * @return the ResponseEntity containing the created BarrioDTO
     */
    @PostMapping("/Comunas/barrios")
    public ResponseEntity<BarrioDTO> createBarrio(@RequestBody BarrioDTO barrioDTO) {
        BarrioDTO createdBarrio = barrioMapper.toDTO(sectorService.createBarrio(barrioMapper.toDomain(barrioDTO)));
        return ResponseEntity.ok(createdBarrio);
    }

}
