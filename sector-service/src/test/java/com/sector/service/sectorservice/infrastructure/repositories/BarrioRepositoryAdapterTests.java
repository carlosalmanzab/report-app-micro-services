package com.sector.service.sectorservice.infrastructure.repositories;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sector.service.sectorservice.domain.Barrio;

@ExtendWith(MockitoExtension.class)
public class BarrioRepositoryAdapterTests {

    // @Mock
    // private BarrioRepository barrioRepository;

    // @InjectMocks
    // private BarrioRepositoryAdapter barrioRepositoryAdapter;

    private BarrioRepository barrioRepository;
    private BarrioRepositoryAdapter barrioRepositoryAdapter;

    @BeforeEach
    public void setup() {
        barrioRepository = mock(BarrioRepository.class);
        barrioRepositoryAdapter = new BarrioRepositoryAdapter(barrioRepository);
    }

    public void testSaveBarrio() {
        Barrio barrio = new Barrio();
    }
}
