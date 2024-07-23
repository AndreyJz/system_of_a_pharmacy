package com.farmacy.unitofmeasure.aplication;

import java.util.Optional;

import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;

public class FindUnitOfMeasureByNameUC {
    private final UnitOfMeasureService unitOfMeasureService;

    public FindUnitOfMeasureByNameUC(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    public Optional<UnitOfMeasure> execute(String name){
        return unitOfMeasureService.findUnitOfMeasureByName(name);
    }
}
