package com.farmacy.country.aplication;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class DeleteCountryUC {
    private final CountryService countryService;

    public DeleteCountryUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public Country execute(int id){
        return countryService.deleteCountry(id);
    }
}
