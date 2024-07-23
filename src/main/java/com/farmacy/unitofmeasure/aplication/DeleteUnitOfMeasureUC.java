package com.farmacy.unitofmeasure.aplication;

import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;

public class DeleteUnitOfMeasureUC {
    private final UnitOfMeasureService unitOfMeasureService;

    public DeleteUnitOfMeasureUC(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    public UnitOfMeasure execute(int id){
        return unitOfMeasureService.deleteUnitOfMeasure(id);
    }
}
