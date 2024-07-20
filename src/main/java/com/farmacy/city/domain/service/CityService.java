package com.farmacy.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.city.domain.entity.City;

public interface CityService {
    void createCity(City city);
    void updateCity(City city);
    City deleteCity(int id);
    Optional<City> findCityById(int id);
    List<City> findAllCities();
    Optional<City> findCityByName(String name);
}
