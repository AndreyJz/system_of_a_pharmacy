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
import com.farmacy.neighborhood.aplication.CreateNeighborhoodUC;
import com.farmacy.neighborhood.aplication.DeleteNeighborhoodUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodByIdUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodByNameUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodsUC;
import com.farmacy.neighborhood.aplication.UpdateNeighborhoodUC;
import com.farmacy.neighborhood.domain.service.NeighborhoodService;
import com.farmacy.neighborhood.infrastructure.NeighborhoodRepository;
import com.farmacy.neighborhood.infrastructure.NeighborhoodUI;
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
    private JButton countryButton, cityButton, neighborhoodButton, hideOptionsButton;
    private JPanel mainPanel, countryPanel, cityPanel, neighborhoodPanel, mainMenuPanel;

    private JButton createCountryButton, listAllCountriesButton, findCountryByIdButton, updateCountryButton, deleteCountryButton, salirCountryButton;
    private JButton createNeighborhoodButton, findAllNeighborhoodsButton, findNeighborhoodByIdButton, updateNeighborhoodButton, deleteNeighborhoodButton, salirNeighborhoodButton;
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
        neighborhoodButton = new JButton("Neighborhood");
        neighborhoodButton.addActionListener(this);
        mainMenuPanel.add(countryButton);
        mainMenuPanel.add(cityButton);
        mainMenuPanel.add(neighborhoodButton);

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


        // Crear panel para opciones de ciudad
        neighborhoodPanel = new JPanel();
        neighborhoodPanel.setLayout(new GridLayout(6, 1, 10, 10)); // 6 filas, 1 columna

        createNeighborhoodButton = new JButton("Create Neigborhood");
        createNeighborhoodButton.addActionListener(this);
        neighborhoodPanel.add(createNeighborhoodButton);

        findAllNeighborhoodsButton = new JButton("List of Neigborhoods");
        findAllNeighborhoodsButton.addActionListener(this);
        neighborhoodPanel.add(findAllNeighborhoodsButton);

        findNeighborhoodByIdButton = new JButton("Search Neigborhood");
        findNeighborhoodByIdButton.addActionListener(this);
        neighborhoodPanel.add(findNeighborhoodByIdButton);

        updateNeighborhoodButton = new JButton("Update Neigborhood");
        updateNeighborhoodButton.addActionListener(this);
        neighborhoodPanel.add(updateNeighborhoodButton);

        deleteNeighborhoodButton = new JButton("Delete Neigborhood 💀");
        deleteNeighborhoodButton.addActionListener(this);
        neighborhoodPanel.add(deleteNeighborhoodButton);

        salirNeighborhoodButton = new JButton("Salir");
        salirNeighborhoodButton.addActionListener(this);
        neighborhoodPanel.add(salirNeighborhoodButton);

        // Inicialmente ocultar los paneles de opciones
        countryPanel.setVisible(false);
        cityPanel.setVisible(false);
        neighborhoodPanel.setVisible(false);


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
            neighborhoodPanel.setVisible(false);
            cityPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == cityButton) {
            // Mostrar el panel de opciones de ciudad y ocultar el panel de opciones de país
            mainPanel.add(cityPanel, BorderLayout.CENTER);
            cityPanel.setVisible(true);
            neighborhoodPanel.setVisible(false);
            countryPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == neighborhoodButton) {
            // Mostrar el panel de opciones de ciudad y ocultar el panel de opciones de país
            mainPanel.add(neighborhoodPanel, BorderLayout.CENTER);
            neighborhoodPanel.setVisible(true);
            countryPanel.setVisible(false);
            cityPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == hideOptionsButton) {
            // Mostrar los botones principales y ocultar los paneles de opciones
            mainMenuPanel.setVisible(true);
            countryPanel.setVisible(false);
            neighborhoodPanel.setVisible(false);
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

        if (e.getSource() == createNeighborhoodButton) {
            NeighborhoodService ns = new NeighborhoodRepository();
            CityService ccs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(ccs);
            FindCityByNameUC fcnuc = new FindCityByNameUC(ccs);
            CreateNeighborhoodUC cnuc = new CreateNeighborhoodUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(cnuc,fcsuc,fcnuc);
            uiNeighborhood.createNeighborhood();
        } else if (e.getSource() == findAllNeighborhoodsButton) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodsUC fnsuc = new FindNeighborhoodsUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(fnsuc);
            uiNeighborhood.listNeighborhoods();
        } else if (e.getSource() == findNeighborhoodByIdButton) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodByIdUC fnuc = new FindNeighborhoodByIdUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(fnuc);
            uiNeighborhood.FindNeighborhoodByID();
        } else if (e.getSource() == updateNeighborhoodButton) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodsUC fcsuc = new FindNeighborhoodsUC(ns);
            FindNeighborhoodByNameUC fcnuc = new FindNeighborhoodByNameUC(ns);
            UpdateNeighborhoodUC unuc = new UpdateNeighborhoodUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(unuc, fcsuc, fcnuc);
            uiNeighborhood.updateNeighborhood();
        } else if (e.getSource() == deleteNeighborhoodButton) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodsUC fcsuc = new FindNeighborhoodsUC(ns);
            FindNeighborhoodByNameUC fcnuc = new FindNeighborhoodByNameUC(ns);
            DeleteNeighborhoodUC dcuc = new DeleteNeighborhoodUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(dcuc, fcsuc, fcnuc);
            uiNeighborhood.deleteNeighborhood();
        } else if (e.getSource() == salirNeighborhoodButton) {
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
