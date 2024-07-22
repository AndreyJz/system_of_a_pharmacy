package com.farmacy.administrationroute.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;

public interface AdministrationRouteService {
    void createAdministrationRoute(AdministrationRoute administrationRoute);
    void updateAdministrationRoute(AdministrationRoute administrationRoute);
    AdministrationRoute deleteAdministrationRoute(int id);
    Optional<AdministrationRoute> findAdministrationRouteById(int id);
    List<AdministrationRoute> findAllAdministrationRoute();
    Optional<AdministrationRoute> findAdministrationRouteByName(String name);
}
