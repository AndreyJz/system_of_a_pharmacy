package com.farmacy.city.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CityRepository implements CityService {

    private Connection connection;

    public CityRepository(Connection connection) {
        try {
            Properties props = new Properties();
            props.getClass().getClassLoader().getResourceAsStream("configdb.properties");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = java.sql.DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCity(City city) {
        try {
            String query = "INSERT INTO cities (city,country) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, city.getName());
            ps.setInt(2, city.getIdCountry());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void UpdateCity(City city) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateCity'");
    }

    @Override
    public City deleteCity(City city) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCity'");
    }

    @Override
    public List<City> findCountryById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCountryById'");
    }

    @Override
    public Optional<List<City>> findAllCities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllCities'");
    }

}
