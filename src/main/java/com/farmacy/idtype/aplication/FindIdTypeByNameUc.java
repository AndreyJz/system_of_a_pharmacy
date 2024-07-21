package com.farmacy.idtype.aplication;

import java.util.Optional;

import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.idtype.domain.service.IdTypeService;

public class FindIdTypeByNameUc {
    private final IdTypeService idTypeService;

    public FindIdTypeByNameUc(IdTypeService idTypeService) {
        this.idTypeService = idTypeService;
    }

    public Optional<IdType> execute(String name){
        return idTypeService.findIdTypeByName(name);
    }
}
