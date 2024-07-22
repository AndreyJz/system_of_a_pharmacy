package com.farmacy.activeingredient.aplication;

import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class DeleteActiveIngredientUC {
    private final ActiveIngredientService activeIngredientService;

    public DeleteActiveIngredientUC(ActiveIngredientService activeIngredientService) {
        this.activeIngredientService = activeIngredientService;
    }

    public ActiveIngredient execute(int id){
        return activeIngredientService.deleteActiveIngredient(id);
    }
}
