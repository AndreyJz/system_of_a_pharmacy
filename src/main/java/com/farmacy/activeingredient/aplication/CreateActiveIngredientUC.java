package com.farmacy.activeingredient.aplication;


import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class CreateActiveIngredientUC {
    private final ActiveIngredientService activeIngredientService;

    public CreateActiveIngredientUC(ActiveIngredientService activeIngredientService) {
        this.activeIngredientService = activeIngredientService;
    }
    
    public void execute(ActiveIngredient activeIngredient) {
        activeIngredientService.createActiveIngredient(activeIngredient);
    }
    
}
