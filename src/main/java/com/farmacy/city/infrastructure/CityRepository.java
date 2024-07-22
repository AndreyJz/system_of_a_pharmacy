package com.farmacy.city.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CityRepository implements CityService {
    private Connection connection;

    public CityRepository() {
        try {
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
    public void createCity(City city) {
        try {
            String query = "INSERT INTO cities (city,country) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, city.getName());
            ps.setInt(2, city.getIdCountry());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void updateCity(City city) {
        String query = "UPDATE cities SET city = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, city.getName());
            ps.setInt(2, city.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("City with ID " + city.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update city with ID " + city.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City deleteCity(int id) {
        String query = "DELETE FROM cities WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hola, soy un hp error");
        }
        return null;
    }

    @Override
    public Optional<City> findCityById(int id) {
        String query = "SELECT id, city, country FROM cities WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        City city = new City(rs.getInt("id"), rs.getString("city"), rs.getInt("country"));
                        return Optional.of(city);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<City> findAllCities() {
        String query = "SELECT id,city,country FROM cities";
        List<City> cities = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City city = new City();
                    city.setId(rs.getInt("id"));
                    city.setName(rs.getString("city"));
                    city.setIdCountry(rs.getInt("country"));
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("soy un hp error");
        }
        return cities;
    }

    @Override
    public Optional<City> findCityByName (String name) {
        String query = "SELECT id,city,country FROM cities WHERE city = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    City city = new City(rs.getInt("id"), rs.getString("city"), rs.getInt("country"));
                    return Optional.of(city);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return Optional.empty();
    }

}
