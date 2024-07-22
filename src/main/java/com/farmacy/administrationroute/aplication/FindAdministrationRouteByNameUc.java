package com.farmacy.administrationroute.aplication;

import java.util.Optional;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class FindAdministrationRouteByNameUc {
    private final AdministrationRouteService administrationRouteService;

    public FindAdministrationRouteByNameUc(AdministrationRouteService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public Optional<AdministrationRoute> execute(String name){
        return administrationRouteService.findAdministrationRouteByName(name);
    }
}
