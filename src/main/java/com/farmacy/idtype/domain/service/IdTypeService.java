package com.farmacy.idtype.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.idtype.domain.entity.IdType;

public interface IdTypeService {
    void createIdType(IdType idType);
    void updateIdType(IdType idType);
    IdType deleteIdType(int id);
    Optional<IdType> findIdTypeById(int id);
    List<IdType> findAllIdType();
    Optional<IdType> findIdTypeByName(String name);
}
