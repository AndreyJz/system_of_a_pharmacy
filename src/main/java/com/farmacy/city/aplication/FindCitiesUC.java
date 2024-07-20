package com.farmacy.city.aplication;

import java.util.List;
import java.util.Optional;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class FindCitiesUC {
    private final CityService cityService;

    public FindCitiesUC(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute(){
        return cityService.findAllCities();
    }
}
