package com.sector.service.sectorservice.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sector.service.sectorservice.application.services.BarrioServiceImpl;
import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.domain.port.out.persistence.IBarrioRepositoryPort;
import com.sector.service.sectorservice.domain.port.out.persistence.IComunaRepositoryPort;

@ExtendWith(MockitoExtension.class)
public class BarrioServiceImplTest {

    @Mock
    private IBarrioRepositoryPort barrioRepository;

    @InjectMocks
    private BarrioServiceImpl barrioService;

    @Mock
    private IComunaRepositoryPort comunaRepository;

    private Comuna comuna;

    private Barrio barrio;

    @BeforeEach
    public void setup() {
        comuna = Comuna.builder()
        .id(1L)
        .nombre("Comuna 1")
        .fechaCreacion(LocalDateTime.now())
        .build();

        barrio = Barrio.builder()
        .id(1L)
        .nombre("Barrio 1")
        .fechaCreacion(LocalDateTime.now())
        .build();
    }

    @DisplayName("Test find barrio for id")
    @Test
    void testGetById() {
        //Given 
        given(barrioRepository.findById(1L)).willReturn(Optional.of(barrio));
        //When
        Barrio barrioSaved = barrioService.getById(barrio.getId()).get();
        //Then
        assertEquals(barrioSaved, barrioService.getById(1L).get());
        assertThat(barrioSaved).isNotNull();
    }
    
    @DisplayName("Test get all barrios")
    @Test
    void testGetAll() {
        //Given 
        List<Barrio> expectedBarrios = List.of(barrio);
        given(barrioRepository.findAll()).willReturn(expectedBarrios);
        //When
        List<Barrio> barrioListSaved = barrioService.getAll();
        //Then
        assertEquals(barrioListSaved, expectedBarrios);
    }

    @DisplayName("Test get barrios by comuna id")
    @Test
    void testGetByComunaId() {
        //Given 
        List<Barrio> expectedBarrios = List.of(barrio);
        given(barrioRepository.findByComunaId(1L)).willReturn(expectedBarrios);
        //When
        List<Barrio> barrioListSaved = barrioService.getByComunaId(1L);
        //Then
        assertEquals(barrioListSaved, expectedBarrios);
    }
}
