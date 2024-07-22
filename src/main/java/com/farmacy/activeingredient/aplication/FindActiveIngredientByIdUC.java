package com.farmacy.activeingredient.aplication;


import java.util.Optional;

import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class FindActiveIngredientByIdUC {
    private final ActiveIngredientService activeIngredientService;

    public FindActiveIngredientByIdUC(ActiveIngredientService activeIngredientService) {
        this.activeIngredientService = activeIngredientService;
    }

    public Optional<ActiveIngredient> execute(int id){
        return activeIngredientService.findActiveIngredientById(id);
    }
}
