package com.farmacy.idtype.aplication;


import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.idtype.domain.service.IdTypeService;

public class SaveIdTypeUC {
    private final IdTypeService idTypeService;

    public SaveIdTypeUC(IdTypeService idTypeService) {
        this.idTypeService = idTypeService;
    }
    
    public void execute(IdType IdType) {
        idTypeService.createIdType(IdType);
    }
    
}
