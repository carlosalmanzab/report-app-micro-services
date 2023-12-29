package com.sector.service.sectorservice.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.Set;

import com.sector.service.sectorservice.domain.Comuna;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comunas")
public class ComunaEntity {
    @Id
    @Column(name = "co_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "co_nombre")
    private String nombre;
    @Builder.Default
    @Column(name = "co_fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    /**
     * Converts a Comuna domain model object to a ComunaEntity object.
     *
     * @param comuna The Comuna object to convert.
     * @return The converted ComunaEntity object.
     */
    public static ComunaEntity fromDomainModel(Comuna comuna) {
        return ComunaEntity
                .builder()
                .id(comuna.getId())
                .nombre(comuna.getNombre())
                .fechaCreacion(comuna.getFechaCreacion())
                .build();
    }

    /**
     * Convert the current object to a Comuna domain model.
     *
     * @return The Comuna object created from the current object's id, nombre, and
     *         fechaCreacion.
     */
    public Comuna toDomainModel() {
        return Comuna
                .builder()
                .id(id)
                .nombre(nombre)
                .fechaCreacion(fechaCreacion)
                .build();
    }

}
