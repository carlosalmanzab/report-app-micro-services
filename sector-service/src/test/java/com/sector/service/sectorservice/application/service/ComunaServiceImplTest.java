package com.sector.service.sectorservice.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

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

import com.sector.service.sectorservice.application.services.ComunaServiceImpl;
import com.sector.service.sectorservice.domain.Barrio;
import com.sector.service.sectorservice.domain.Comuna;
import com.sector.service.sectorservice.domain.port.out.persistence.IComunaRepositoryPort;

@ExtendWith(MockitoExtension.class)
public class ComunaServiceImplTest {

    @Mock
    private IComunaRepositoryPort comunaRepository;

    @InjectMocks
    private ComunaServiceImpl comunaService;

    private Comuna comuna;

    private Barrio barrio;

    /**
     * Sets up the test environment before each test case is executed.
     *
     * @BeforeEach
     */
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

    /**
     * Test get comuna by id.
     */
    @DisplayName("Test get comuna by id")
    @Test
    public void testGetComunaById() {
        // Given
        given(comunaRepository.findById(1L)).willReturn(Optional.of(comuna));

        // When
        Optional<Comuna> optionalComunaSaved = comunaService.getById(1L);

        // Then
        assertThat(optionalComunaSaved).isPresent();
        Comuna comunaSaved = optionalComunaSaved.get();
        assertThat(comunaSaved).isSameAs(comuna);
    }

    /**
     * Test get all comunas.
     */
    @DisplayName("Test get all comunas")
    @Test
    public void testGetAllComunas() {
        //Given
        List<Comuna> expectedComunas = List.of(comuna);
        given(comunaRepository.findAll()).willReturn(expectedComunas);
        //When
        List<Comuna> comunaListSaved = comunaService.getAll();
        //Then
        assertEquals(comunaListSaved, expectedComunas);
    }

}
