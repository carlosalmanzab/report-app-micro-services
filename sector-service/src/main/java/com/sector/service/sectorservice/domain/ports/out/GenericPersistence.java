package com.sector.service.sectorservice.domain.ports.out;

import java.util.List;
import java.util.Optional;

public interface GenericPersistence<T, I> {
    T save(T model);
    Optional<T> findById(I id);
    List<T> findAll();
    Optional<T> update(T model);
    boolean deleteById(I id);
}
