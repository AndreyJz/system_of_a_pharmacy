package com.farmacy.unitofmeasure.aplication;


import java.util.Optional;

import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;

public class FindUnitOfMeasureByIdUC {
    private final UnitOfMeasureService unitOfMeasureService;

    public FindUnitOfMeasureByIdUC(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    public Optional<UnitOfMeasure> execute(int id){
        return unitOfMeasureService.findUnitOfMeasureById(id);
    }
}
