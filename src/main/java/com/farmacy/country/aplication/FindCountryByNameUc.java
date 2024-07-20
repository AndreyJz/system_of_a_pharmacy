package com.farmacy.country.aplication;

import java.util.Optional;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class FindCountryByNameUc {
    private final CountryService countryService;

    public FindCountryByNameUc(CountryService countryService) {
        this.countryService = countryService;
    }

    public Optional<Country> execute(String name){
        return countryService.findCountryByName(name);
    }
}
