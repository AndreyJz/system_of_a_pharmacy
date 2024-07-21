package com.farmacy.idtype.aplication;


import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.idtype.domain.service.IdTypeService;

public class UpdateIdTypeUC {
    private final IdTypeService idTypeService;

    public UpdateIdTypeUC(IdTypeService idTypeService) {
        this.idTypeService = idTypeService;
    }

    public void execute(IdType IdType){
        idTypeService.updateIdType(IdType);
    }
}
