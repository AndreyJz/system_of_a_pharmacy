package com.farmacy.activeingredient.aplication;


import java.util.Optional;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class FindAdministrationRouteByIdUC {
    private final ActiveIngredientService administrationRouteService;

    public FindAdministrationRouteByIdUC(ActiveIngredientService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public Optional<ActiveIngredient> execute(int id){
        return administrationRouteService.findAdministrationRouteById(id);
    }
}
