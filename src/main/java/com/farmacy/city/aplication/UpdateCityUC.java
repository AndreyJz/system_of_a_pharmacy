package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class UpdateCityUC {
    private final CityService cityService;

    public UpdateCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (City city) {
        cityService.updateCity(city);
    }
}
