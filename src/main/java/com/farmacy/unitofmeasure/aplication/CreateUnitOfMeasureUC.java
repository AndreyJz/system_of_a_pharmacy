package com.farmacy.unitofmeasure.aplication;


import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;

public class CreateUnitOfMeasureUC {
    private final UnitOfMeasureService unitOfMeasureService;

    public CreateUnitOfMeasureUC(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }
    
    public void execute(UnitOfMeasure unitOfMeasure) {
        unitOfMeasureService.createUnitOfMeasure(unitOfMeasure);
    }
    
}
