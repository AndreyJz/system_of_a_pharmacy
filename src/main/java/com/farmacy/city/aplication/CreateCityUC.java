package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CreateCityUC {
    private final CityService cityService;

    public CreateCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (City city){
        cityService.createCity(city);
    }
}
