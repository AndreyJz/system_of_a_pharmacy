package com.farmacy.administrationroute.aplication;


import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class CreateAdministrationRouteUC {
    private final AdministrationRouteService administrationRouteService;

    public CreateAdministrationRouteUC(AdministrationRouteService administrationRouteService) {
        this.administrationRouteService = administrationRouteService;
    }
    
    public void execute(AdministrationRoute administrationRoute) {
        administrationRouteService.createAdministrationRoute(administrationRoute);
    }
    
}