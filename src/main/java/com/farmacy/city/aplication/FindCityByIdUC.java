package com.farmacy.city.aplication;

import java.util.Optional;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class FindCityByIdUC {
    private final CityService cityService;

    public FindCityByIdUC(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute(int id){
        return cityService.findCityById(id);
    }
}
