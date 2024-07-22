package com.farmacy.administrationroute.aplication;

import java.util.List;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class FindAdministrationRoutesUC {
    private final AdministrationRouteService administrationRouteService;

    public FindAdministrationRoutesUC(AdministrationRouteService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public List<AdministrationRoute> execute(){
        return administrationRouteService.findAllAdministrationRoute();
    }
}
