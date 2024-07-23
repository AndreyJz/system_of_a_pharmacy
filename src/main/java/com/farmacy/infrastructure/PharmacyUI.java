package com.farmacy.infrastructure;


import com.farmacy.country.aplication.DeleteCountryUC;
import com.farmacy.country.aplication.FindCountriesUC;
import com.farmacy.country.aplication.FindCountryByIdUC;
import com.farmacy.country.aplication.FindCountryByNameUc;
import com.farmacy.country.aplication.SaveCountryUC;
import com.farmacy.country.aplication.UpdateCountryUC;
import com.farmacy.country.domain.service.CountryService;
import com.farmacy.activeingredient.aplication.CreateActiveIngredientUC;
import com.farmacy.activeingredient.aplication.DeleteActiveIngredientUC;
import com.farmacy.activeingredient.aplication.FindActiveIngredientByIdUC;
import com.farmacy.activeingredient.aplication.FindActiveIngredientByNameUC;
import com.farmacy.activeingredient.aplication.FindActiveIngredientsUC;
import com.farmacy.activeingredient.aplication.UpdateActiveIngredientUC;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;
import com.farmacy.activeingredient.infrastructure.ActiveIngredientRepository;
import com.farmacy.activeingredient.infrastructure.ActiveIngredientUI;
import com.farmacy.administrationroute.aplication.CreateAdministrationRouteUC;
import com.farmacy.administrationroute.aplication.DeleteAdministrationRouteUC;
import com.farmacy.administrationroute.aplication.FindAdministrationRouteByIdUC;
import com.farmacy.administrationroute.aplication.FindAdministrationRouteByNameUc;
import com.farmacy.administrationroute.aplication.FindAdministrationRoutesUC;
import com.farmacy.administrationroute.aplication.UpdateAdministrationRouteUC;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;
import com.farmacy.administrationroute.infrastructure.AdministrationRouteRepository;
import com.farmacy.administrationroute.infrastructure.AdministrationRouteUI;
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
import com.farmacy.unitofmeasure.aplication.CreateUnitOfMeasureUC;
import com.farmacy.unitofmeasure.aplication.DeleteUnitOfMeasureUC;
import com.farmacy.unitofmeasure.aplication.FindUnitOfMeasureByIdUC;
import com.farmacy.unitofmeasure.aplication.FindUnitOfMeasureByNameUC;
import com.farmacy.unitofmeasure.aplication.FindUnitOfMeasuresUC;
import com.farmacy.unitofmeasure.aplication.UpdateUnitOfMeasureUC;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;
import com.farmacy.unitofmeasure.infrastructure.UnitOfMeasureRepository;
import com.farmacy.unitofmeasure.infrastructure.UnitOfMeasureUI;
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
import java.util.HashMap;
import java.util.Map;

public class PharmacyUI extends JFrame implements ActionListener {
    private static final String CREATE = "Create";
    private static final String LIST = "List";
    private static final String SEARCH = "Search";
    private static final String UPDATE = "Update";
    private static final String DELETE = "Delete";
    private static final String EXIT = "Exit";

    private Map<String, JPanel> panels;
    private Map<String, JButton> buttons;

    private JPanel mainMenuPanel;
    private JPanel contentPanel;

    public PharmacyUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Pharmacy Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panels = new HashMap<>();
        buttons = new HashMap<>();

        setLayout(new BorderLayout());

        mainMenuPanel = new JPanel(new GridLayout(0,4,10,10));
        initializeMainPanel();
        add(mainMenuPanel, BorderLayout.NORTH);

        contentPanel = new JPanel(new CardLayout());
        initializeSubPanels();
        add(contentPanel, BorderLayout.CENTER);
        contentPanel.setVisible(false);

        setVisible(true);
    }

    private void initializeMainPanel() {
        String[] mainOptions = {"Country", "City", "Neighborhood", "IdType", "Customer", "AdministrationRoute", "ActiveIngredient", "UnitOfMeasure"};
        for (String option : mainOptions) {
            addButton(mainMenuPanel, option, this);
        }
    }

    private void initializeSubPanels() {
        String[] entities = {"Country", "City", "Neighborhood", "IdType", "Customer", "AdministrationRoute", "ActiveIngredient", "UnitOfMeasure"};
        for (String entity : entities) {
            JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
            addEntityButtons(panel, entity);
            panels.put(entity, panel);
            contentPanel.add(panel, entity);
        }
    }

    private void addEntityButtons(JPanel panel, String entity) {
        addButton(panel, CREATE + " " + entity, this);
        addButton(panel, LIST + " " + entity, this);
        addButton(panel, SEARCH + " " + entity, this);
        addButton(panel, UPDATE + " " + entity, this);
        addButton(panel, DELETE + " " + entity, this);
        addButton(panel, EXIT, this);
    }

    private void addButton(JPanel panel, String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
        buttons.put(text, button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (panels.containsKey(command)) {
            showPanel(command);
        } else if (command.startsWith(CREATE)) {
            handleCreate(command.split(" ")[1]);
        } else if (command.startsWith(LIST)) {
            handleList(command.split(" ")[1]);
        } else if (command.startsWith(SEARCH)) {
            handleSearch(command.split(" ")[1]);
        } else if (command.startsWith(UPDATE)) {
            handleUpdate(command.split(" ")[1]);
        } else if (command.startsWith(DELETE)) {
            handleDelete(command.split(" ")[1]);
        } else if (command.equals(EXIT)) {
            showPanel("MAIN");  // Volver al panel principal en lugar de salir
            contentPanel.setVisible(false);
        }
    }

    private void showPanel(String panelName) {
        contentPanel.setVisible(true);
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
        System.out.println("Showing panel: " + panelName);  // Depuración
    }

    private void handleCreate(String entity) {
        if (entity.equals("Country")) {
            CountryService cs = new CountryRepository();
            SaveCountryUC scuc = new SaveCountryUC(cs);
            CountryUI uiCountry = new CountryUI(scuc);
            uiCountry.CreateCountry();
        } else if (entity.equals("City")) {
            CityService cs = new CityRepository();
            CountryService ccs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(ccs);
            FindCountryByNameUc fciduc = new FindCountryByNameUc(ccs);
            CreateCityUC ccuc = new CreateCityUC(cs);
            CityUI uiCity = new CityUI(ccuc,fcsuc,fciduc);
            uiCity.createCity();
        } else if (entity.equals("Neighborhood")) {
            NeighborhoodService ns = new NeighborhoodRepository();
            CityService ccs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(ccs);
            FindCityByNameUC fcnuc = new FindCityByNameUC(ccs);
            CreateNeighborhoodUC cnuc = new CreateNeighborhoodUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(cnuc,fcsuc,fcnuc);
            uiNeighborhood.createNeighborhood();
        } else if (entity.equals("IdType")) {
            IdTypeService cs = new IdTypeRepository();
            SaveIdTypeUC scuc = new SaveIdTypeUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(scuc);
            uiIdType.CreateIdType();
        } else if (entity.equals("Customer")) {
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
        } else if (entity.equals("AdministrationRoute")) {
            AdministrationRouteService cs = new AdministrationRouteRepository();
            CreateAdministrationRouteUC scuc = new CreateAdministrationRouteUC(cs);
            AdministrationRouteUI uiAdministrationRoute = new AdministrationRouteUI(scuc);
            uiAdministrationRoute.CreateAdministrationRoute();
        } else if (entity.equals("ActiveIngredient")) {
            ActiveIngredientService cs = new ActiveIngredientRepository();
            CreateActiveIngredientUC scuc = new CreateActiveIngredientUC(cs);
            ActiveIngredientUI uiActiveIngredient = new ActiveIngredientUI(scuc);
            uiActiveIngredient.CreateActiveIngredient();
        } else if (entity.equals("UnitOfMeasure")) {
            UnitOfMeasureService cs = new UnitOfMeasureRepository();
            CreateUnitOfMeasureUC scuc = new CreateUnitOfMeasureUC(cs);
            UnitOfMeasureUI uiUnitOfMeasure = new UnitOfMeasureUI(scuc);
            uiUnitOfMeasure.CreateUnitOfMeasure();
        }
    }

    private void handleList(String entity) {
        if (entity.equals("Country")) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            CountryUI uiCountry = new CountryUI(fcsuc);
            uiCountry.ListCountries();
        } else if (entity.equals("City")) {
            CityService cs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(cs);
            CityUI uiCity = new CityUI(fcsuc);
            uiCity.listCities();
        } else if (entity.equals("Neighborhood")) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodsUC fnsuc = new FindNeighborhoodsUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(fnsuc);
            uiNeighborhood.listNeighborhoods();
        } else if (entity.equals("IdType")) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypesUC fcsuc = new FindIdTypesUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(fcsuc);
            uiIdType.ListIdTypes();
        } else if (entity.equals("Customer")) {
            CustomerService cs = new CustomerRepository();
            FindCustomersUC fcsuc = new FindCustomersUC(cs);
            CustomerUI uiCustomer = new CustomerUI(fcsuc);
            uiCustomer.ListCustomers();
        } else if (entity.equals("AdministrationRoute")) {
            AdministrationRouteService cs = new AdministrationRouteRepository();
            FindAdministrationRoutesUC fcsuc = new FindAdministrationRoutesUC(cs);
            AdministrationRouteUI uiAdministrationRoute = new AdministrationRouteUI(fcsuc);
            uiAdministrationRoute.ListAdministrationRoutes();
        } else if (entity.equals("ActiveIngredient")) {
            ActiveIngredientService cs = new ActiveIngredientRepository();
            FindActiveIngredientsUC fcsuc = new FindActiveIngredientsUC(cs);
            ActiveIngredientUI uiActiveIngredient = new ActiveIngredientUI(fcsuc);
            uiActiveIngredient.ListActiveIngredients();
        } else if (entity.equals("UnitOfMeasure")) {
            UnitOfMeasureService cs = new UnitOfMeasureRepository();
            FindUnitOfMeasuresUC fcsuc = new FindUnitOfMeasuresUC(cs);
            UnitOfMeasureUI uiUnitOfMeasure = new UnitOfMeasureUI(fcsuc);
            uiUnitOfMeasure.ListUnitOfMeasures();
        }
    }

    private void handleSearch(String entity) {
        if (entity.equals("Country")) {
            CountryService cs = new CountryRepository();
            FindCountryByIdUC fcuc = new FindCountryByIdUC(cs);
            CountryUI uiCountry = new CountryUI(fcuc);
            uiCountry.FindCountryByID();
        } else if (entity.equals("City")) {
            CityService cs = new CityRepository();
            FindCityByIdUC fcuc = new FindCityByIdUC(cs);
            CityUI uiCity = new CityUI(fcuc);
            uiCity.FindCityByID();
        } else if (entity.equals("Neighborhood")) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodByIdUC fnuc = new FindNeighborhoodByIdUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(fnuc);
            uiNeighborhood.FindNeighborhoodByID();
        } else if (entity.equals("IdType")) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypeByIdUC fcuc = new FindIdTypeByIdUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(fcuc);
            uiIdType.FindIdTypeByID();
        } else if (entity.equals("Customer")) {
            CustomerService cs = new CustomerRepository();
            FindCustomerByIdUC fcuc = new FindCustomerByIdUC(cs);
            CustomerUI uiCustomer = new CustomerUI(fcuc);
            uiCustomer.FindCustomerById();
        } else if (entity.equals("AdministrationRoute")) {
            AdministrationRouteService cs = new AdministrationRouteRepository();
            FindAdministrationRouteByIdUC fcuc = new FindAdministrationRouteByIdUC(cs);
            AdministrationRouteUI uiAdministrationRoute = new AdministrationRouteUI(fcuc);
            uiAdministrationRoute.FindAdministrationRouteByID();
        } else if (entity.equals("ActiveIngredient")) {
            ActiveIngredientService cs = new ActiveIngredientRepository();
            FindActiveIngredientByIdUC fcuc = new FindActiveIngredientByIdUC(cs);
            ActiveIngredientUI uiActiveIngredient = new ActiveIngredientUI(fcuc);
            uiActiveIngredient.FindActiveIngredientByID();
        } else if (entity.equals("UnitOfMeasure")) {
            UnitOfMeasureService cs = new UnitOfMeasureRepository();
            FindUnitOfMeasureByIdUC fcuc = new FindUnitOfMeasureByIdUC(cs);
            UnitOfMeasureUI uiUnitOfMeasure = new UnitOfMeasureUI(fcuc);
            uiUnitOfMeasure.FindUnitOfMeasureByID();
        }
    }

    private void handleUpdate(String entity) {
        if (entity.equals("Country")) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            FindCountryByNameUc fciduc = new FindCountryByNameUc(cs);
            UpdateCountryUC ucuc = new UpdateCountryUC(cs);
            CountryUI uiCountry = new CountryUI(ucuc, fcsuc, fciduc);
            uiCountry.UpdateCountry();
        } else if (entity.equals("City")) {
            CityService cs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(cs);
            FindCityByNameUC fcnuc = new FindCityByNameUC(cs);
            UpdateCityUC ucuc = new UpdateCityUC(cs);
            CityUI uiCity = new CityUI(ucuc, fcsuc, fcnuc);
            uiCity.updateCity();
        } else if (entity.equals("Neighborhood")) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodsUC fcsuc = new FindNeighborhoodsUC(ns);
            FindNeighborhoodByNameUC fcnuc = new FindNeighborhoodByNameUC(ns);
            UpdateNeighborhoodUC unuc = new UpdateNeighborhoodUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(unuc, fcsuc, fcnuc);
            uiNeighborhood.updateNeighborhood();
        } else if (entity.equals("IdType")) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypesUC fcsuc = new FindIdTypesUC(cs);
            FindIdTypeByNameUc fciduc = new FindIdTypeByNameUc(cs);
            UpdateIdTypeUC ucuc = new UpdateIdTypeUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(ucuc, fcsuc, fciduc);
            uiIdType.UpdateIdType();
        } else if (entity.equals("Customer")) {
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
        } else if (entity.equals("AdministrationRoute")) {
            AdministrationRouteService cs = new AdministrationRouteRepository();
            FindAdministrationRoutesUC fcsuc = new FindAdministrationRoutesUC(cs);
            FindAdministrationRouteByNameUc fciduc = new FindAdministrationRouteByNameUc(cs);
            UpdateAdministrationRouteUC ucuc = new UpdateAdministrationRouteUC(cs);
            AdministrationRouteUI uiAdministrationRoute = new AdministrationRouteUI(ucuc, fcsuc, fciduc);
            uiAdministrationRoute.UpdateAdministrationRoute();
        } else if (entity.equals("ActiveIngredient")) {
            ActiveIngredientService cs = new ActiveIngredientRepository();
            FindActiveIngredientsUC fcsuc = new FindActiveIngredientsUC(cs);
            FindActiveIngredientByNameUC fciduc = new FindActiveIngredientByNameUC(cs);
            UpdateActiveIngredientUC ucuc = new UpdateActiveIngredientUC(cs);
            ActiveIngredientUI uiActiveIngredient = new ActiveIngredientUI(ucuc, fcsuc, fciduc);
            uiActiveIngredient.UpdateActiveIngredient();
        } else if (entity.equals("UnitOfMeasure")) {
            UnitOfMeasureService cs = new UnitOfMeasureRepository();
            FindUnitOfMeasuresUC fcsuc = new FindUnitOfMeasuresUC(cs);
            FindUnitOfMeasureByNameUC fciduc = new FindUnitOfMeasureByNameUC(cs);
            UpdateUnitOfMeasureUC ucuc = new UpdateUnitOfMeasureUC(cs);
            UnitOfMeasureUI uiUnitOfMeasure = new UnitOfMeasureUI(ucuc, fcsuc, fciduc);
            uiUnitOfMeasure.UpdateUnitOfMeasure();
        }
    }

    private void handleDelete(String entity) {
        if (entity.equals("Country")) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            FindCountryByNameUc fciduc = new FindCountryByNameUc(cs);
            DeleteCountryUC dcuc = new DeleteCountryUC(cs);
            CountryUI uiCountry = new CountryUI(dcuc, fcsuc, fciduc);
            uiCountry.DeleteCountry();
        } else if (entity.equals("City")) {
            CityService cs = new CityRepository();
            FindCitiesUC fcsuc = new FindCitiesUC(cs);
            FindCityByNameUC fcnuc = new FindCityByNameUC(cs);
            DeleteCityUC dcuc = new DeleteCityUC(cs);
            CityUI uiCity = new CityUI(dcuc, fcsuc, fcnuc);
            uiCity.deleteCity();
        } else if (entity.equals("Neighborhood")) {
            NeighborhoodService ns = new NeighborhoodRepository();
            FindNeighborhoodsUC fcsuc = new FindNeighborhoodsUC(ns);
            FindNeighborhoodByNameUC fcnuc = new FindNeighborhoodByNameUC(ns);
            DeleteNeighborhoodUC dcuc = new DeleteNeighborhoodUC(ns);
            NeighborhoodUI uiNeighborhood = new NeighborhoodUI(dcuc, fcsuc, fcnuc);
            uiNeighborhood.deleteNeighborhood();
        } else if (entity.equals("IdType")) {
            IdTypeService cs = new IdTypeRepository();
            FindIdTypesUC fcsuc = new FindIdTypesUC(cs);
            FindIdTypeByNameUc fciduc = new FindIdTypeByNameUc(cs);
            DeleteIdTypeUC dcuc = new DeleteIdTypeUC(cs);
            IdTypeUI uiIdType = new IdTypeUI(dcuc, fcsuc, fciduc);
            uiIdType.DeleteIdType();
        } else if (entity.equals("Customer")) {
            CustomerService cs = new CustomerRepository();
            FindCustomersUC fcsuc = new FindCustomersUC(cs);
            FindCustomerByNameUC fciduc = new FindCustomerByNameUC(cs);
            DeleteCustomerUC dcuc = new DeleteCustomerUC(cs);
            CustomerUI uiCustomer = new CustomerUI(dcuc, fcsuc, fciduc);
            uiCustomer.DeleteCustomer();
        } else if (entity.equals("AdministrationRoute")) {
            AdministrationRouteService cs = new AdministrationRouteRepository();
            FindAdministrationRoutesUC fcsuc = new FindAdministrationRoutesUC(cs);
            FindAdministrationRouteByNameUc fciduc = new FindAdministrationRouteByNameUc(cs);
            DeleteAdministrationRouteUC dcuc = new DeleteAdministrationRouteUC(cs);
            AdministrationRouteUI uiAdministrationRoute = new AdministrationRouteUI(dcuc, fcsuc, fciduc);
            uiAdministrationRoute.DeleteAdministrationRoute();
        } else if (entity.equals("ActiveIngredient")) {
            ActiveIngredientService cs = new ActiveIngredientRepository();
            FindActiveIngredientsUC fcsuc = new FindActiveIngredientsUC(cs);
            FindActiveIngredientByNameUC fciduc = new FindActiveIngredientByNameUC(cs);
            DeleteActiveIngredientUC dcuc = new DeleteActiveIngredientUC(cs);
            ActiveIngredientUI uiActiveIngredient = new ActiveIngredientUI(dcuc, fcsuc, fciduc);
            uiActiveIngredient.DeleteActiveIngredient();
        } else if (entity.equals("UnitOfMeasure")) {
            UnitOfMeasureService cs = new UnitOfMeasureRepository();
            FindUnitOfMeasuresUC fcsuc = new FindUnitOfMeasuresUC(cs);
            FindUnitOfMeasureByNameUC fciduc = new FindUnitOfMeasureByNameUC(cs);
            DeleteUnitOfMeasureUC dcuc = new DeleteUnitOfMeasureUC(cs);
            UnitOfMeasureUI uiUnitOfMeasure = new UnitOfMeasureUI(dcuc, fcsuc, fciduc);
            uiUnitOfMeasure.DeleteUnitOfMeasure();
        }
    }
}

