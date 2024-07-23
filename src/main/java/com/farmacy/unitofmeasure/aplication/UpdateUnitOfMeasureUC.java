package com.farmacy.unitofmeasure.aplication;


import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;

public class UpdateUnitOfMeasureUC {
    private final UnitOfMeasureService unitOfMeasureService;

    public UpdateUnitOfMeasureUC(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    public void execute(UnitOfMeasure unitOfMeasure){
        unitOfMeasureService.updateUnitOfMeasure(unitOfMeasure);
    }
}
