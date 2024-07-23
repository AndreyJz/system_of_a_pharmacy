package com.farmacy.unitofmeasure.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;

public interface UnitOfMeasureService {
    void createUnitOfMeasure(UnitOfMeasure unitOfMeasure);
    void updateUnitOfMeasure(UnitOfMeasure unitOfMeasure);
    UnitOfMeasure deleteUnitOfMeasure(int id);
    Optional<UnitOfMeasure> findUnitOfMeasureById(int id);
    List<UnitOfMeasure> findAllUnitOfMeasure();
    Optional<UnitOfMeasure> findUnitOfMeasureByName(String name);
}
