package com.farmacy.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.city.domain.entity.City;

public interface CityService {
    void createCity(City city);
    void UpdateCity(City city);
    City deleteCity(City city);
    List<City> findCountryById(String id);
    Optional<List<City>> findAllCities();
}
