package com.farmacy.idtype.aplication;


import java.util.Optional;

import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.idtype.domain.service.IdTypeService;

public class FindIdTypeByIdUC {
    private final IdTypeService idTypeService;

    public FindIdTypeByIdUC(IdTypeService idTypeService) {
        this.idTypeService = idTypeService;
    }

    public Optional<IdType> execute(int id){
        return idTypeService.findIdTypeById(id);
    }
}
