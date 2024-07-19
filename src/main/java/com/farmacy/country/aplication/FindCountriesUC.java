package com.farmacy.country.aplication;

import java.util.List;
import java.util.Optional;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class FindCountriesUC {
    private final CountryService countryService;

    public FindCountriesUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> execute(){
        return countryService.findAllCountry();
    }
}
