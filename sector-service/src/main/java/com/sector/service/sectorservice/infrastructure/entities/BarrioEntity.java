package com.sector.service.sectorservice.infrastructure.entities;

import java.time.LocalDateTime;

import com.sector.service.sectorservice.domain.Barrio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "barrios")
public class BarrioEntity {
    @Id
    @Column(name = "ba_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ba_nombre")
    private String nombre;
    @Builder.Default
    @Column(name = "ba_fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @ManyToOne()
    @JoinColumn(name = "ba_comuna_id")
    private ComunaEntity comuna;
    /**
     * Converts a Barrio object from the domain model to a BarrioEntity object.
     *
     * @param barrio the Barrio object to be converted
     * @return the converted BarrioEntity object
     */
    public static BarrioEntity fromDomainModel(Barrio barrio) {
        return BarrioEntity
                .builder()
                .id(barrio.getId())
                .nombre(barrio.getNombre())
                .fechaCreacion(barrio.getFechaCreacion())
                .build();
    }

    /**
     * Converts the current object to a Barrio domain model.
     *
     * @return A new instance of the Barrio domain model.
     */
    public Barrio toDomainModel() {
        return Barrio
                .builder()
                .id(id)
                .nombre(nombre)
                .fechaCreacion(fechaCreacion)
                .build();
    }
}
