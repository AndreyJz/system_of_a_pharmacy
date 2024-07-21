package com.farmacy.idtype.aplication;

import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.idtype.domain.service.IdTypeService;

public class DeleteIdTypeUC {
    private final IdTypeService IdTypeService;

    public DeleteIdTypeUC(IdTypeService idTypeService) {
        this.IdTypeService = idTypeService;
    }

    public IdType execute(int id){
        return IdTypeService.deleteIdType(id);
    }
}
