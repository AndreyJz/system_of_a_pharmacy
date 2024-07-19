package com.farmacy;

import com.farmacy.country.aplication.CountryUI;
import com.farmacy.country.aplication.SaveCountryUC;
import com.farmacy.country.domain.service.CountryService;
import com.farmacy.country.infrastructure.CountryRepository;

public class Main {
    public static void main(String[] args) {
        CountryService cs = new CountryRepository();
        SaveCountryUC scuc = new SaveCountryUC(cs);
        CountryUI uiCountry = new CountryUI(scuc);
        uiCountry.frmRegCountry();
    }
}