package com.farmacy.administrationroute.aplication;


import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class UpdateAdministrationRouteUC {
    private final AdministrationRouteService administrationRouteService;

    public UpdateAdministrationRouteUC(AdministrationRouteService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }

    public void execute(AdministrationRoute administrationRoute){
        administrationRouteService.updateAdministrationRoute(administrationRoute);
    }
}
