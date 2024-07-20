package com.farmacy.country.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.country.domain.entity.Country;

public interface CountryService {
    void createCountry(Country country);
    void updateCountry(Country country);
    Country deleteCountry(int id);
    Optional<Country> findCountryById(int id);
    List<Country> findAllCountry();
    Optional<Country> findCountryByName(String name);
}
