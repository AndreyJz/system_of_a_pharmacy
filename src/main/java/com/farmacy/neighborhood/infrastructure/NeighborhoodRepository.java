package com.farmacy.neighborhood.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.neighborhood.domain.service.NeighborhoodService;
import com.farmacy.neighborhood.domain.entity.Neighborhood;

public class NeighborhoodRepository implements NeighborhoodService {
    private Connection connection;

    public NeighborhoodRepository() {
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
    public void createNeighborhood(Neighborhood neighborhood) {
        try {
            String query = "INSERT INTO neighborhoods (neighborhood,city) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, neighborhood.getName());
            ps.setInt(2, neighborhood.getIdCity());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void updateNeighborhood(Neighborhood neighborhood) {
        String query = "UPDATE neighborhoods SET neighborhood = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, neighborhood.getName());
            ps.setInt(2, neighborhood.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Neighborhood with ID " + neighborhood.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update neighborhood with ID " + neighborhood.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Neighborhood deleteNeighborhood(int id) {
        String query = "DELETE FROM neighborhoods WHERE id = ?";
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
    public Optional<Neighborhood> findNeighborhoodById(int id) {
        String query = "SELECT id, neighborhood, city FROM neighborhoods WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Neighborhood neighborhood = new Neighborhood(rs.getInt("id"), rs.getString("neighborhood"), rs.getInt("city"));
                        return Optional.of(neighborhood);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Neighborhood> findAllNeighborhoods() {
        String query = "SELECT id,neighborhood,city FROM neighborhoods";
        List<Neighborhood> neighborhoods = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Neighborhood neighborhood = new Neighborhood();
                    neighborhood.setId(rs.getInt("id"));
                    neighborhood.setName(rs.getString("neighborhood"));
                    neighborhood.setIdCity(rs.getInt("city"));
                    neighborhoods.add(neighborhood);
                }
            }
        } catch (Exception e) {
            System.out.println("soy un hp error");
        }
        return neighborhoods;
    }


    @Override
    public Optional<Neighborhood> findNeighborhoodByName (String name) {
        String query = "SELECT id,neighborhood,city FROM neighborhoods WHERE neighborhood = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Neighborhood neihgborhood = new Neighborhood(rs.getInt("id"), rs.getString("neighborhood"), rs.getInt("city"));
                    return Optional.of(neihgborhood);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return Optional.empty();
    }

}
