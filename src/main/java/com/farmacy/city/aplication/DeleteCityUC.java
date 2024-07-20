package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class DeleteCityUC {
    private final CityService cityService;

    public DeleteCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (int id) {
        cityService.deleteCity(id);
    }
}
