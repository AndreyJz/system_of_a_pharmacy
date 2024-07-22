package com.farmacy.activeingredient.aplication;

import java.util.Optional;

import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class FindActiveIngredientByNameUC {
    private final ActiveIngredientService activeIngredientService;

    public FindActiveIngredientByNameUC(ActiveIngredientService activeIngredientService) {
        this.activeIngredientService = activeIngredientService;
    }

    public Optional<ActiveIngredient> execute(String name){
        return activeIngredientService.findActiveIngredientByName(name);
    }
}
