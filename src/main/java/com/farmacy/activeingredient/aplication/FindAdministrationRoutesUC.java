package com.farmacy.activeingredient.aplication;

import java.util.List;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class FindAdministrationRoutesUC {
    private final ActiveIngredientService administrationRouteService;

    public FindAdministrationRoutesUC(ActiveIngredientService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public List<ActiveIngredient> execute(){
        return administrationRouteService.findAllAdministrationRoute();
    }
}
