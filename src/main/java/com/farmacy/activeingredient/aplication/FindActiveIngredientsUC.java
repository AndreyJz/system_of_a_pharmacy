package com.farmacy.activeingredient.aplication;

import java.util.List;

import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class FindActiveIngredientsUC {
    private final ActiveIngredientService activeIngredientService;

    public FindActiveIngredientsUC(ActiveIngredientService activeIngredientService) {
        this.activeIngredientService = activeIngredientService;
    }

    public List<ActiveIngredient> execute(){
        return activeIngredientService.findAllActiveIngredient();
    }
}
