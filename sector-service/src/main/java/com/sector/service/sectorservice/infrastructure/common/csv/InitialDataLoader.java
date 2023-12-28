package com.sector.service.sectorservice.infrastructure.common.csv;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sector.service.sectorservice.infrastructure.entities.BarrioEntity;
import com.sector.service.sectorservice.infrastructure.entities.ComunaEntity;
import com.sector.service.sectorservice.infrastructure.repositories.BarrioRepository;
import com.sector.service.sectorservice.infrastructure.repositories.ComunaRepository;

import jakarta.annotation.PostConstruct;

@Component
public class InitialDataLoader {
    @Value("${reader.file.comuna}")
    private String comunaFile;
    @Value("${reader.file.barrio}")
    private String barrioFile;
    private final ComunaRepository comunaRepository;
    private final BarrioRepository barrioRepository;

    InitialDataLoader(ComunaRepository comunaRepository, BarrioRepository barrioRepository) {
        this.comunaRepository = comunaRepository;
        this.barrioRepository = barrioRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        if (comunaRepository.count() == 0) loadDataComunaEntity();
        if (barrioRepository.count() == 0) loadDataBarrioEntity();
    }

    private void loadDataComunaEntity() throws IOException {
        InputStream inputStream = new FileInputStream(comunaFile);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        List<ComunaEntity> comunas = CSVConverter.convertToListComunaEntity(inputStreamReader);
        comunas.forEach(comunaRepository::save);
    }

    private void loadDataBarrioEntity() throws IOException {
        InputStream inputStream = new FileInputStream(barrioFile);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        List<BarrioEntity> barrios = CSVConverter.convertToListBarrioEntity(inputStreamReader, comunaRepository);
        barrios.forEach(barrioRepository::save);
    }

}
