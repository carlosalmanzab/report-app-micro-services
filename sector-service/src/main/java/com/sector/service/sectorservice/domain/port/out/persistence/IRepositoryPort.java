package com.sector.service.sectorservice.domain.port.out.persistence;

import java.util.List;
import java.util.Optional;

public interface IRepositoryPort<T, I> {
    T save(T model);
    Optional<T> findById(I id);
    List<T> findAll();
    Optional<T> update(T model);
    boolean deleteById(I id);
}
