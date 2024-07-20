package com.farmacy.city.aplication;

import java.util.Optional;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class FindCityByNameUC {
    private final CityService cityService;

    public FindCityByNameUC(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute(String name) {
        return cityService.findCityByName(name);
    }
}
