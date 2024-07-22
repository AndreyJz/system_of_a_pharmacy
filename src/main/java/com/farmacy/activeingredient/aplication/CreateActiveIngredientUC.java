package com.farmacy.activeingredient.aplication;


import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class CreateActiveIngredientUC {
    private final ActiveIngredientService ActiveIngredientService;

    public CreateActiveIngredientUC(ActiveIngredientService ActiveIngredientService) {
        this.ActiveIngredientService = ActiveIngredientService;
    }
    
    public void execute(ActiveIngredient ActiveIngredient) {
        ActiveIngredientService.createActiveIngredient(ActiveIngredient);
    }
    
}
