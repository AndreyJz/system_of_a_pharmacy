package com.farmacy.activeingredient.aplication;


import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class UpdateAdministrationRouteUC {
    private final ActiveIngredientService administrationRouteService;

    public UpdateAdministrationRouteUC(ActiveIngredientService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public void execute(ActiveIngredient administrationRoute){
        administrationRouteService.updateAdministrationRoute(administrationRoute);
    }
}
