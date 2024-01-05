package com.sector.service.sectorservice.infrastructure.common.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sector.service.sectorservice.infrastructure.entities.BarrioEntity;
import com.sector.service.sectorservice.infrastructure.entities.ComunaEntity;
import com.sector.service.sectorservice.infrastructure.repositories.ComunaRepository;

public class CSVConverter {

    private CSVConverter() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Converts the data from an input stream reader into a list of ComunaEntity
     * objects.
     *
     * @param inputStreamReader the input stream reader containing the data to be
     *                          converted
     * @return the list of ComunaEntity objects converted from the input data
     * @throws IOException if an I/O error occurs while reading the input stream
     */
    public static List<ComunaEntity> convertToListComunaEntity(InputStreamReader inputStreamReader) throws IOException {

        List<ComunaEntity> comunas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] columns = line.split(",");

                ComunaEntity comuna = ComunaEntity
                        .builder()
                        .id(Long.parseLong(columns[0]))
                        .nombre(columns[1])
                        .fechaCreacion(LocalDateTime.now())
                        .build();

                comunas.add(comuna);
            }

            return comunas;
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * Converts the given input stream reader into a list of BarrioEntity objects.
     *
     * @param inputStreamReader the input stream reader to convert
     * @param comunaRepository  the repository for retrieving ComunaEntity objects
     * @return the list of BarrioEntity objects converted from the input stream
     *         reader
     * @throws IOException if there is an error reading the input stream
     */
    public static List<BarrioEntity> convertToListBarrioEntity(InputStreamReader inputStreamReader,
            ComunaRepository comunaRepository)
            throws IOException {

        List<BarrioEntity> barrios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(inputStreamReader)) {
            String line = null;
            
            if ((line = br.readLine()) == null) {
                return barrios;
            }

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                Optional<ComunaEntity> comuna = comunaRepository.findById(Long.parseLong(columns[1]));
                if (!comuna.isPresent())
                    continue;

                BarrioEntity barrio = BarrioEntity
                        .builder()
                        .id(Long.parseLong(columns[0]))
                        .nombre(columns[2].replace("\"", ""))
                        .fechaCreacion(LocalDateTime.now())
                        .comuna(comuna.get())
                        .build();

                barrios.add(barrio);
            }
            return barrios;
        } catch (IOException e) {
            throw e;
        }
    }

}
