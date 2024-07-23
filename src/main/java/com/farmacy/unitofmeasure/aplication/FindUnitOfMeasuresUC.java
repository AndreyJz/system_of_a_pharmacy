package com.farmacy.unitofmeasure.aplication;

import java.util.List;

import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;

public class FindUnitOfMeasuresUC {
    private final UnitOfMeasureService UnitOfMeasureService;

    public FindUnitOfMeasuresUC(UnitOfMeasureService UnitOfMeasureService) {
        this.UnitOfMeasureService = UnitOfMeasureService;
    }

    public List<UnitOfMeasure> execute(){
        return UnitOfMeasureService.findAllUnitOfMeasure();
    }
}
