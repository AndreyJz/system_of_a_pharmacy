package com.farmacy.activeingredient.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.activeingredient.domain.entity.ActiveIngredient;

public interface ActiveIngredientService {
    void createActiveIngredient(ActiveIngredient ActiveIngredient);
    void updateActiveIngredient(ActiveIngredient ActiveIngredient);
    ActiveIngredient deleteActiveIngredient(int id);
    Optional<ActiveIngredient> findActiveIngredientById(int id);
    List<ActiveIngredient> findAllActiveIngredient();
    Optional<ActiveIngredient> findActiveIngredientByName(String name);
}
