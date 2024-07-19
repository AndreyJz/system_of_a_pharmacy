package com.farmacy.country.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class CountryRepository implements CountryService {
    private Connection connection;

    public CountryRepository(){
        try{
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCountry(Country country) {
        try {
            String query = "INSERT INTO countries (country) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, country.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void updateCountry(Country country) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCountry'");
    }

    @Override
    public Country deleteCountry(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCountry'");
    }

    @Override
    public Optional<Country> findCountryById(int id) {
        String query = "SELECT id, country FROM countries WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Country country = new Country(rs.getInt("id"), rs.getString("country"));
                        return Optional.of(country);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public Optional<List<Country>> findAllCountry() {
        String query = "SELECT country FROM countries";
        List<Country> countries = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Country country = new Country();
                    country.setName(rs.getString("country"));
                    countries.add(country);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return Optional.empty();
    }

}
