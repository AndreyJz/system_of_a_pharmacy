package com.farmacy.country.aplication;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class UpdateCountryUC {
    private final CountryService countryService;

    public UpdateCountryUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public void execute(Country country){
        countryService.updateCountry(country);
    }
}
