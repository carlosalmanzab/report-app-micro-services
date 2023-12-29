package com.sector.service.sectorservice.application.services;

import java.util.List;
import java.util.Optional;

public interface IService<T, I> {
    Optional<T> getById(I id);
    List<T> getAll();
}
