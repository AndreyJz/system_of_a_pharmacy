package com.farmacy.country.aplication;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class SaveCountryUC {
    private final CountryService countryService;

    public SaveCountryUC(CountryService countryService) {
        this.countryService = countryService;
    }
    
    public void execute(Country country) {
        countryService.createCountry(country);
    }
    
}
