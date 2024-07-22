package com.farmacy.activeingredient.aplication;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class DeleteAdministrationRouteUC {
    private final ActiveIngredientService administrationRouteService;

    public DeleteAdministrationRouteUC(ActiveIngredientService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public ActiveIngredient execute(int id){
        return administrationRouteService.deleteAdministrationRoute(id);
    }
}
