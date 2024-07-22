package com.farmacy.administrationroute.aplication;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class DeleteAdministrationRouteUC {
    private final AdministrationRouteService administrationRouteService;

    public DeleteAdministrationRouteUC(AdministrationRouteService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public AdministrationRoute execute(int id){
        return administrationRouteService.deleteAdministrationRoute(id);
    }
}
