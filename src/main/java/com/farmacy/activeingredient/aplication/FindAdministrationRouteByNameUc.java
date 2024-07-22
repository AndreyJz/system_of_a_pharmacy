package com.farmacy.activeingredient.aplication;

import java.util.Optional;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class FindAdministrationRouteByNameUc {
    private final ActiveIngredientService administrationRouteService;

    public FindAdministrationRouteByNameUc(ActiveIngredientService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public Optional<ActiveIngredient> execute(String name){
        return administrationRouteService.findAdministrationRouteByName(name);
    }
}
