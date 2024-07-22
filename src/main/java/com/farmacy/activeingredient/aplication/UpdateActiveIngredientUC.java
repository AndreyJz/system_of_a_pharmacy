package com.farmacy.activeingredient.aplication;


import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class UpdateActiveIngredientUC {
    private final ActiveIngredientService activeIngredientService;

    public UpdateActiveIngredientUC(ActiveIngredientService activeIngredientService) {
        this.activeIngredientService = activeIngredientService;
    }

    public void execute(ActiveIngredient activeIngredient){
        activeIngredientService.updateActiveIngredient(activeIngredient);
    }
}
