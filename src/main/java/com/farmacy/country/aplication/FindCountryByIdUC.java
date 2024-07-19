package com.farmacy.country.aplication;

import java.util.Optional;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class FindCountryByIdUC {
    private final CountryService countryService;

    public FindCountryByIdUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public Optional<Country> execute(int id){
        return countryService.findCountryById(id);
    }
}
