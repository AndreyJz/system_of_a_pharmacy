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
import com.farmacy.customer.aplication.CreateCustomerUC;
import com.farmacy.customer.aplication.DeleteCustomerUC;
import com.farmacy.customer.aplication.FindCustomerByIdUC;
import com.farmacy.customer.aplication.FindCustomerByNameUC;
import com.farmacy.customer.aplication.FindCustomersUC;
import com.farmacy.customer.aplication.UpdateCustomerUC;
import com.farmacy.customer.domain.service.CustomerService;
import com.farmacy.customer.infrastructure.CustomerRepository;
import com.farmacy.customer.infrastructure.CustomerUI;
import com.farmacy.idtype.aplication.DeleteIdTypeUC;
import com.farmacy.idtype.aplication.FindIdTypeByIdUC;
import com.farmacy.idtype.aplication.FindIdTypeByNameUc;
import com.farmacy.idtype.aplication.FindIdTypesUC;
import com.farmacy.idtype.aplication.SaveIdTypeUC;
import com.farmacy.idtype.aplication.UpdateIdTypeUC;
import com.farmacy.idtype.domain.service.IdTypeService;
import com.farmacy.idtype.infrastructure.IdTypeRepository;
import com.farmacy.idtype.infrastructure.IdTypeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JButton countryButton, cityButton, neighborhoodButton, idTypeButton, customerButton, hideOptionsButton;
    private JPanel mainPanel, countryPanel, cityPanel, neighborhoodPanel, idTypePanel, customerPanel, mainMenuPanel;

    private JButton createCountryButton, listAllCountriesButton, findCountryByIdButton, updateCountryButton, deleteCountryButton, salirCountryButton;
    private JButton createCityButton, findAllCitiesButton, findCityByIdButton, updateCityButton, deleteCityButton, salirCityButton;
    private JButton createNeighborhoodButton, findAllNeighborhoodsButton, findNeighborhoodByIdButton, updateNeighborhoodButton, deleteNeighborhoodButton, salirNeighborhoodButton;
    private JButton createIdTypeButton, findAllIdTypesButton, findIdTypeByIdButton, updateIdTypeButton, deleteIdTypeButton, salirIdTypeButton;
    private JButton createCustomerButton, findAllCustomersButton, findCustomerByIdButton, updateCustomerButton, deleteCustomerButton, salirCustomerButton;

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
        idTypeButton = new JButton("idTypes");
        idTypeButton.addActionListener(this);
        customerButton = new JButton("Customers");
        customerButton.addActionListener(this);
        mainMenuPanel.add(countryButton);
        mainMenuPanel.add(cityButton);
        mainMenuPanel.add(neighborhoodButton);
        mainMenuPanel.add(idTypeButton);
        mainMenuPanel.add(customerButton);

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


        // Crear panel para opciones de neighborhood
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

        
        // Crear panel para opciones de idType
        idTypePanel = new JPanel();
        idTypePanel.setLayout(new GridLayout(6, 1, 10, 10)); // 6 filas, 1 columna

        createIdTypeButton = new JButton("Create IdType");
        createIdTypeButton.addActionListener(this);
        idTypePanel.add(createIdTypeButton);

        findAllIdTypesButton = new JButton("List of IdTypes");
        findAllIdTypesButton.addActionListener(this);
        idTypePanel.add(findAllIdTypesButton);

        findIdTypeByIdButton = new JButton("Search IdType");
        findIdTypeByIdButton.addActionListener(this);
        idTypePanel.add(findIdTypeByIdButton);

        updateIdTypeButton = new JButton("Update IdType");
        updateIdTypeButton.addActionListener(this);
        idTypePanel.add(updateIdTypeButton);

        deleteIdTypeButton = new JButton("Delete IdType 💀");
        deleteIdTypeButton.addActionListener(this);
        idTypePanel.add(deleteIdTypeButton);

        salirIdTypeButton = new JButton("Salir");
        salirIdTypeButton.addActionListener(this);
        idTypePanel.add(salirIdTypeButton);


        // Crear panel para opciones de customer
        customerPanel = new JPanel();
        customerPanel.setLayout(new GridLayout(6, 1, 10, 10)); // 6 filas, 1 columna

        createCustomerButton = new JButton("Create Customer");
        createCustomerButton.addActionListener(this);
        customerPanel.add(createCustomerButton);

        findAllCustomersButton = new JButton("List of Customers");
        findAllCustomersButton.addActionListener(this);
        customerPanel.add(findAllCustomersButton);

        findCustomerByIdButton = new JButton("Search Customer");
        findCustomerByIdButton.addActionListener(this);
        customerPanel.add(findCustomerByIdButton);

        updateCustomerButton = new JButton("Update Customer");
        updateCustomerButton.addActionListener(this);
        customerPanel.add(updateCustomerButton);

        deleteCustomerButton = new JButton("Delete Customer 💀");
        deleteCustomerButton.addActionListener(this);
        customerPanel.add(deleteCustomerButton);

        salirCustomerButton = new JButton("Salir");
        salirCustomerButton.addActionListener(this);
        customerPanel.add(salirCustomerButton);

        // Inicialmente ocultar los paneles de opciones
        countryPanel.setVisible(false);
        cityPanel.setVisible(false);
        neighborhoodPanel.setVisible(false);
        idTypePanel.setVisible(false);
        customerPanel.setVisible(false);


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
            idTypePanel.setVisible(false);
            customerPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == cityButton) {
            // Mostrar el panel de opciones de ciudad y ocultar el panel de opciones de país
            mainPanel.add(cityPanel, BorderLayout.CENTER);
            cityPanel.setVisible(true);
            neighborhoodPanel.setVisible(false);
            countryPanel.setVisible(false);
            idTypePanel.setVisible(false);
            customerPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == neighborhoodButton) {
            // Mostrar el panel de opciones de ciudad y ocultar el panel de opciones de país
            mainPanel.add(neighborhoodPanel, BorderLayout.CENTER);
            neighborhoodPanel.setVisible(true);
            countryPanel.setVisible(false);
            cityPanel.setVisible(false);
            idTypePanel.setVisible(false);
            customerPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == idTypeButton) {
            // Mostrar el panel de opciones de ciudad y ocultar el panel de opciones de país
            mainPanel.add(idTypePanel, BorderLayout.CENTER);
            idTypePanel.setVisible(true);
            countryPanel.setVisible(false);
            cityPanel.setVisible(false);
            neighborhoodPanel.setVisible(false);
            customerPanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == customerButton) {
            // Mostrar el panel de opciones de ciudad y ocultar el panel de opciones de país
            mainPanel.add(customerPanel, BorderLayout.CENTER);
            customerPanel.setVisible(true);
            countryPanel.setVisible(false);
            cityPanel.setVisible(false);
            neighborhoodPanel.setVisible(false);
            idTypePanel.setVisible(false);
            hideOptionsButton.setVisible(true); // Mostrar botón de ocultar opciones
        } else if (e.getSource() == hideOptionsButton) {
            // Mostrar los botones principales y ocultar los paneles de opciones
            mainMenuPanel.setVisible(true);
            countryPanel.setVisible(false);
            cityPanel.setVisible(false);
            neighborhoodPanel.setVisible(false);
            idTypePanel.setVisible(false);
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


        if (e.getSource() == createIdTypeButton) {
            IdTypeService cs = new IdTypeRepository();
            SaveIdTypeUC scuc = new SaveIdTypeUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(scuc);
            uiIdType.CreateIdType();
        } else if (e.getSource() == findAllIdTypesButton) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypesUC fcsuc = new FindIdTypesUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(fcsuc);
            uiIdType.ListIdTypes();
        } else if (e.getSource() == findIdTypeByIdButton) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypeByIdUC fcuc = new FindIdTypeByIdUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(fcuc);
            uiIdType.FindIdTypeByID();
        } else if (e.getSource() == updateIdTypeButton) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypesUC fcsuc = new FindIdTypesUC(cs);
            FindIdTypeByNameUc fciduc = new FindIdTypeByNameUc(cs);
            UpdateIdTypeUC ucuc = new UpdateIdTypeUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(ucuc, fcsuc, fciduc);
            uiIdType.UpdateIdType();
        } else if (e.getSource() == deleteIdTypeButton) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypesUC fcsuc = new FindIdTypesUC(cs);
            FindIdTypeByNameUc fciduc = new FindIdTypeByNameUc(cs);
            DeleteIdTypeUC dcuc = new DeleteIdTypeUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(dcuc, fcsuc, fciduc);
            uiIdType.DeleteIdType();
        } else if (e.getSource() == salirIdTypeButton) {
            JOptionPane.showMessageDialog(this, "Saliendo del programa...");
            System.exit(0); // Salir del programa al presionar Salir
        }

        if (e.getSource() == createCustomerButton) {
            NeighborhoodService ns = new NeighborhoodRepository();
            IdTypeService its = new IdTypeRepository();
            CustomerService cs = new CustomerRepository();
            FindNeighborhoodsUC fnuc = new FindNeighborhoodsUC(ns);
            FindIdTypesUC fcsuc = new FindIdTypesUC(its);
            FindNeighborhoodByNameUC fnnuc = new FindNeighborhoodByNameUC(ns);
            FindIdTypeByNameUc fcnuc = new FindIdTypeByNameUc(its);
            CreateCustomerUC cuc = new CreateCustomerUC(cs);
            CustomerUI uiCustomer = new CustomerUI(cuc,fnuc,fnnuc,fcsuc,fcnuc);
            uiCustomer.CreateCustomer();
        } else if (e.getSource() == findAllCustomersButton) {
            CustomerService cs = new CustomerRepository();
            FindCustomersUC fcsuc = new FindCustomersUC(cs);
            CustomerUI uiCustomer = new CustomerUI(fcsuc);
            // uiCustomer.ListCustomers();
        } else if (e.getSource() == findCustomerByIdButton) {
            CustomerService cs = new CustomerRepository();
            FindCustomerByIdUC fcuc = new FindCustomerByIdUC(cs);
            CustomerUI uiCustomer = new CustomerUI(fcuc);
            // uiCustomer.FindCustomerById();
        } else if (e.getSource() == updateCustomerButton) {
            NeighborhoodService ns = new NeighborhoodRepository();
            IdTypeService its = new IdTypeRepository();
            CustomerService cs = new CustomerRepository();
            FindNeighborhoodsUC fnuc = new FindNeighborhoodsUC(ns);
            FindIdTypesUC fitsuc = new FindIdTypesUC(its);
            FindNeighborhoodByIdUC fniduc = new FindNeighborhoodByIdUC(ns);
            FindIdTypeByIdUC fitiduc = new FindIdTypeByIdUC(its);
            FindNeighborhoodByNameUC fnnuc = new FindNeighborhoodByNameUC(ns);
            FindIdTypeByNameUc fitnuc = new FindIdTypeByNameUc(its);
            FindCustomersUC fcsuc = new FindCustomersUC(cs);
            FindCustomerByNameUC fciduc = new FindCustomerByNameUC(cs);
            UpdateCustomerUC ucuc = new UpdateCustomerUC(cs);
            CustomerUI uiCustomer = new CustomerUI(ucuc, fcsuc, fciduc, fnuc, fnnuc, fitsuc, fitnuc, fitiduc, fniduc);
            uiCustomer.UpdateCustomer();
        } else if (e.getSource() == deleteCustomerButton) {
            CustomerService cs = new CustomerRepository();
            FindCustomersUC fcsuc = new FindCustomersUC(cs);
            FindCustomerByNameUC fciduc = new FindCustomerByNameUC(cs);
            DeleteCustomerUC dcuc = new DeleteCustomerUC(cs);
            // CustomerUI uiCustomer = new CustomerUI(dcuc, fcsuc, fciduc);
            // uiCustomer.DeleteCustomer();
        } else if (e.getSource() == salirCustomerButton) {
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
