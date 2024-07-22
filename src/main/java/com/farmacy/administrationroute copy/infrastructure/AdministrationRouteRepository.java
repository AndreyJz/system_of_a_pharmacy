package com.farmacy.administrationroute.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.administrationroute.domain.entity.AdministrationRoute;
import com.farmacy.administrationroute.domain.service.AdministrationRouteService;

public class AdministrationRouteRepository implements AdministrationRouteService {
    private Connection connection;

    public AdministrationRouteRepository(){
        try{
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            // jdbc:mysql://localhost:3306/pharmacy
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createAdministrationRoute(AdministrationRoute administrationRoute) {
        try {
            String query = "INSERT INTO administrationRoutes (administration_route) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, administrationRoute.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void updateAdministrationRoute(AdministrationRoute administrationRoute) {
        String query = "UPDATE administrationRoutes SET administration_route = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, administrationRoute.getName());
            ps.setInt(2, administrationRoute.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("AdministrationRoute with ID " + administrationRoute.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update Administration Route with ID " + administrationRoute.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AdministrationRoute deleteAdministrationRoute(int id) {
        String query = "DELETE FROM administrationRoutes WHERE id = ?";
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
    public Optional<AdministrationRoute> findAdministrationRouteById(int id) {
        String query = "SELECT id, administration_route FROM administrationRoutes WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        AdministrationRoute administrationRoute = new AdministrationRoute(rs.getInt("id"), rs.getString("administration_route"));
                        return Optional.of(administrationRoute);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public List<AdministrationRoute> findAllAdministrationRoute() {
        String query = "SELECT id,administration_route FROM administrationRoutes";
        List<AdministrationRoute> AdministrationRoutes = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AdministrationRoute administrationRoute = new AdministrationRoute();
                    administrationRoute.setId(rs.getInt("id"));
                    administrationRoute.setName(rs.getString("administration_route"));
                    AdministrationRoutes.add(administrationRoute);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return AdministrationRoutes;
    }

    @Override
    public Optional<AdministrationRoute> findAdministrationRouteByName(String name) {
        String query = "SELECT id, administration_route FROM administrationRoutes WHERE administration_route = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    AdministrationRoute administrationRoute = new AdministrationRoute(rs.getInt("id"), rs.getString("administration_route"));
                    return Optional.of(administrationRoute);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return Optional.empty();
    }

}
