package com.farmacy;

import com.farmacy.country.aplication.DeleteCountryUC;
import com.farmacy.country.aplication.FindCountriesUC;
import com.farmacy.country.aplication.FindCountryByIdUC;
import com.farmacy.country.aplication.FindCountryByNameUc;
import com.farmacy.country.aplication.SaveCountryUC;
import com.farmacy.country.aplication.UpdateCountryUC;
import com.farmacy.country.domain.service.CountryService;
import com.farmacy.city.aplication.CreateCityUC;
import com.farmacy.city.aplication.DeleteCityUC;
import com.farmacy.city.aplication.FindCitiesUC;
import com.farmacy.city.aplication.FindCityByIdUC;
import com.farmacy.city.aplication.FindCityByNameUC;
import com.farmacy.city.aplication.UpdateCityUC;
import com.farmacy.city.domain.service.CityService;
import com.farmacy.city.infrastructure.CityRepository;
import com.farmacy.city.infrastructure.CityUI;
import com.farmacy.country.infrastructure.CountryRepository;
import com.farmacy.country.infrastructure.CountryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JButton countryButton, cityButton, hideOptionsButton;
    private JPanel mainPanel, countryPanel, cityPanel, mainMenuPanel;

    private JButton createCountryButton, listAllCountriesButton, findCountryByIdButton, updateCountryButton, deleteCountryButton, salirCountryButton;
    private JButton createCityButton, findAllCitiesButton, findCityByIdButton, updateCityButton, deleteCityButton, salirCityButton;

    public Main() {
        // Configuración del JFrame principal
        setTitle("Menú Personalizado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear panel principal y establecer layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Crear panel para los botones principales
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(1, 2, 10, 10)); // 1 fila, 2 columnas

        countryButton = new JButton("Country");
        countryButton.addActionListener(this);
        cityButton = new JButton("City");
        cityButton.addActionListener(this);
        mainMenuPanel.add(countryButton);
        mainMenuPanel.add(cityButton);

        hideOptionsButton = new JButton("Hide Options");
        hideOptionsButton.addActionListener(this);
        hideOptionsButton.setVisible(false); // Inicialmente ocultar el botón de ocultar
        mainMenuPanel.add(hideOptionsButton);

        mainPanel.add(mainMenuPanel, BorderLayout.NORTH);

        // Crear panel para opciones de país
        countryPanel = new JPanel();
        countryPanel.setLayout(new GridLayout(6, 1, 10, 10)); // 6 filas, 1 columna

        createCountryButton = new JButton("Create Country");
        createCountryButton.addActionListener(this);
        countryPanel.add(createCountryButton);

        listAllCountriesButton = new JButton("List of Countries");
        listAllCountriesButton.addActionListener(this);
        countryPanel.add(listAllCountriesButton);

        findCountryByIdButton = new JButton("Search Country");
        findCountryByIdButton.addActionListener(this);
        countryPanel.add(findCountryByIdButton);

        updateCountryButton = new JButton("Update Country");
        updateCountryButton.addActionListener(this);
        countryPanel.add(updateCountryButton);

        deleteCountryButton = new JButton("Delete Country 💀");
        deleteCountryButton.addActionListener(this);
        countryPanel.add(deleteCountryButton);

        salirCountryButton = new JButton("Salir");
        salirCountryButton.addActionListener(this);
        countryPanel.add(salirCountryButton);

        // Crear panel para opciones de ciudad
        cityPanel = new JPanel();
        cityPanel.setLayout(new GridLayout(6, 1, 10, 10)); // 6 filas, 1 columna

        createCityButton = new JButton("Create City");
        createCityButton.addActionListener(this);
        cityPanel.add(createCityButton);

        findAllCitiesButton = new JButton("List of Cities");
        findAllCitiesButton.addActionListener(this);
        cityPanel.add(findAllCitiesButton);

        findCityByIdButton = new JButton("Search City");
        findCityByIdButton.addActionListener(this);
        cityPanel.add(findCityByIdButton);

        updateCityButton = new JButton("Update City");
        updateCityButton.addActionListener(this);
        cityPanel.add(updateCityButton);

        deleteCityButton = new JButton("Delete City 💀");
        deleteCityButton.addActionListener(this);
        cityPanel.add(deleteCityButton);

        salirCityButton = new JButton("Salir");
        salirCityButton.addActionListener(this);
        cityPanel.add(salirCityButton);

        // Inicialmente ocultar los paneles de opciones
        countryPanel.setVisible(false);
        cityPanel.setVisible(false);


        // Agregar el panel principal al JFrame
        add(mainPanel);

        // Mostrar el JFrame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countryButton) {
            // Mostrar el panel de opciones de país y ocultar el panel de opciones de ciudad
            mainPanel.add(countryPanel, BorderLayout.CENTER);
            countryPanel.setVisible(true);
            cityPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == cityButton) {
            // Mostrar el panel de opciones de ciudad y ocultar el panel de opciones de país
            mainPanel.add(cityPanel, BorderLayout.CENTER);
            cityPanel.setVisible(true);
            countryPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == hideOptionsButton) {
            // Mostrar los botones principales y ocultar los paneles de opciones
            mainMenuPanel.setVisible(true);
            countryPanel.setVisible(false);
            cityPanel.setVisible(false);
            hideOptionsButton.setVisible(false); // Ocultar botón de ocultar opciones
        } else if (e.getSource() == createCountryButton) {
            CountryService cs = new CountryRepository();
            SaveCountryUC scuc = new SaveCountryUC(cs);
            CountryUI uiCountry = new CountryUI(scuc);
            uiCountry.CreateCountry();
        } else if (e.getSource() == listAllCountriesButton) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            CountryUI uiCountry = new CountryUI(fcsuc);
            uiCountry.ListCountries();
        } else if (e.getSource() == findCountryByIdButton) {
            CountryService cs = new CountryRepository();
            FindCountryByIdUC fcuc = new FindCountryByIdUC(cs);
            CountryUI uiCountry = new CountryUI(fcuc);
            uiCountry.FindCountryByID();
        } else if (e.getSource() == updateCountryButton) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            FindCountryByNameUc fciduc = new FindCountryByNameUc(cs);
            UpdateCountryUC ucuc = new UpdateCountryUC(cs);
            CountryUI uiCountry = new CountryUI(ucuc, fcsuc, fciduc);
            uiCountry.UpdateCountry();
        } else if (e.getSource() == deleteCountryButton) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            FindCountryByNameUc fciduc = new FindCountryByNameUc(cs);
            DeleteCountryUC dcuc = new DeleteCountryUC(cs);
            CountryUI uiCountry = new CountryUI(dcuc, fcsuc, fciduc);
            uiCountry.DeleteCountry();
        } else if (e.getSource() == salirCountryButton) {
            JOptionPane.showMessageDialog(this, "Saliendo del programa...");
            System.exit(0); // Salir del programa al presionar Salir
        }

        if (e.getSource() == createCityButton) {
            CityService cs = new CityRepository();
            CountryService ccs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(ccs);
            FindCountryByNameUc fciduc = new FindCountryByNameUc(ccs);
            CreateCityUC ccuc = new CreateCityUC(cs);
            CityUI uiCity = new CityUI(ccuc,fcsuc,fciduc);
            uiCity.createCity();
        } else if (e.getSource() == findAllCitiesButton) {
            CityService cs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(cs);
            CityUI uiCity = new CityUI(fcsuc);
            uiCity.listCities();
        } else if (e.getSource() == findCityByIdButton) {
            CityService cs = new CityRepository();
            FindCityByIdUC fcuc = new FindCityByIdUC(cs);
            CityUI uiCity = new CityUI(fcuc);
            uiCity.FindCityByID();
        } else if (e.getSource() == updateCityButton) {
            CityService cs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(cs);
            FindCityByNameUC fcnuc = new FindCityByNameUC(cs);
            UpdateCityUC ucuc = new UpdateCityUC(cs);
            CityUI uiCity = new CityUI(ucuc, fcsuc, fcnuc);
            uiCity.updateCity();
        } else if (e.getSource() == deleteCityButton) {
            CityService cs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(cs);
            FindCityByNameUC fcnuc = new FindCityByNameUC(cs);
            DeleteCityUC dcuc = new DeleteCityUC(cs);
            CityUI uiCity = new CityUI(dcuc, fcsuc, fcnuc);
            uiCity.deleteCity();
        } else if (e.getSource() == salirCityButton) {
            JOptionPane.showMessageDialog(this, "Saliendo del programa...");
            System.exit(0); // Salir del programa al presionar Salir
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
