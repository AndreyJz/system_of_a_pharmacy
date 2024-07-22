package com.farmacy.administrationroute.aplication;


import java.util.Optional;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class FindAdministrationRouteByIdUC {
    private final AdministrationRouteService administrationRouteService;

    public FindAdministrationRouteByIdUC(AdministrationRouteService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public Optional<AdministrationRoute> execute(int id){
        return administrationRouteService.findAdministrationRouteById(id);
    }
}
