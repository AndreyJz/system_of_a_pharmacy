package com.farmacy.idtype.aplication;

import java.util.List;

import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.idtype.domain.service.IdTypeService;

public class FindIdTypesUC {
    private final IdTypeService idTypeService;

    public FindIdTypesUC(IdTypeService idTypeService) {
        this.idTypeService = idTypeService;
    }

    public List<IdType> execute(){
        return idTypeService.findAllIdType();
    }
}
