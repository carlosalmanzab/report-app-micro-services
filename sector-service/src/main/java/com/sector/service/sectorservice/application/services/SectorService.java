package com.sector.service.sectorservice.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.domain.models.Barrio;
import com.sector.service.sectorservice.domain.models.Comuna;
import com.sector.service.sectorservice.domain.ports.in.CreateBarrioUseCase;
import com.sector.service.sectorservice.domain.ports.in.CreateComunaUseCase;
import com.sector.service.sectorservice.domain.ports.in.RetrieveBarrioUseCase;
import com.sector.service.sectorservice.domain.ports.in.RetrieveComunaUseCase;

public class SectorService
        implements CreateBarrioUseCase, CreateComunaUseCase, RetrieveBarrioUseCase, RetrieveComunaUseCase {

    private final CreateBarrioUseCase createBarrioUseCase;
    private final CreateComunaUseCase createComunaUseCase;
    private final RetrieveBarrioUseCase retrieveBarrioUseCase;
    private final RetrieveComunaUseCase retrieveComunaUseCase;

    public SectorService(CreateBarrioUseCase createBarrioUseCase, CreateComunaUseCase createComunaUseCase,
            RetrieveBarrioUseCase retrieveBarrioUseCase, RetrieveComunaUseCase retrieveComunaUseCase) {
        this.createBarrioUseCase = createBarrioUseCase;
        this.createComunaUseCase = createComunaUseCase;
        this.retrieveBarrioUseCase = retrieveBarrioUseCase;
        this.retrieveComunaUseCase = retrieveComunaUseCase;
    }

    /**
     * Retrieves a Comuna by its ID.
     *
     * @param id the ID of the Comuna
     * @return an Optional containing the Comuna with the given ID, or empty if not
     *         found
     */
    @Override
    public Optional<Comuna> getComunaById(Long id) {
        Optional<Comuna> comuna = retrieveComunaUseCase.getComunaById(id);
        if (comuna.isEmpty()) return comuna;

        List<Barrio> barrios = getBarriosByComunaId(id);
        if (barrios.isEmpty()) return comuna;

        comuna.get().setBarrios(barrios);

        return comuna;
    }

    /**
     * Retrieves all the Comuna objects.
     *
     * @return a list of Comuna objects
     */
    @Override
    public List<Comuna> getAllComunas() {
        List<Comuna> comunas = retrieveComunaUseCase.getAllComunas();
        if (comunas.isEmpty()) {
            return comunas;
        }
        comunas.forEach(c -> {
            List<Barrio> barrios = getBarriosByComunaId(c.getId());
            if (!barrios.isEmpty()) {
                c.setBarrios(barrios);
            }
        });
        return comunas;
    }

    /**
     * Retrieves a `Barrio` object by its ID.
     *
     * @param id the ID of the `Barrio` object to retrieve
     * @return an optional `Barrio` object if found, otherwise empty
     */
    @Override
    public Optional<Barrio> getBarrioById(Long id) {
        return retrieveBarrioUseCase.getBarrioById(id);
    }

    /**
     * Retrieves all barrios.
     *
     * @return a list of Barrio objects
     */
    @Override
    public List<Barrio> getAllBarrios() {
        return retrieveBarrioUseCase.getAllBarrios();
    }

    /**
     * Generates a new Comuna object.
     *
     * @param comuna the Comuna object to be created
     * @return the newly created Comuna object
     */
    @Override
    public Comuna createComuna(Comuna comuna) {
        Comuna newComuna = comuna;
        newComuna.setId(null);
        
        newComuna.setBarrios(comuna.getBarrios().stream().map(barrio -> {
            barrio.setId(null);
            barrio.setFechaCreacion(LocalDateTime.now());
            return createBarrioUseCase.createBarrio(barrio);
        }).toList());
        newComuna.setFechaCreacion(LocalDateTime.now());
        return createComunaUseCase.createComuna(newComuna);
    }

    /**
     * Creates a new Barrio.
     *
     * @param barrio the Barrio object to create
     * @return the created Barrio object
     */
    @Override
    public Barrio createBarrio(Barrio barrio) {
        return createBarrioUseCase.createBarrio(barrio);
    }

        /**
     * Retrieves a list of Barrio objects based on the given comuna ID.
     *
     * @param  comunaId  the ID of the comuna to search for
     * @return           a list of Barrio objects associated with the comuna ID
     */
    @Override
    public List<Barrio> getBarriosByComunaId(Long comunaId) {
        return retrieveBarrioUseCase.getBarriosByComunaId(comunaId);
    }


}
