package com.farmacy.activeingredient.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.activeingredient.domain.entity.ActiveIngredient;
import com.farmacy.activeingredient.domain.service.ActiveIngredientService;

public class ActiveIngredientRepository implements ActiveIngredientService {
    private Connection connection;

    public ActiveIngredientRepository(){
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
    public void createActiveIngredient(ActiveIngredient activeIngredient) {
        try {
            String query = "INSERT INTO ActiveIngredients (administration_route) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, activeIngredient.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void updateActiveIngredient(ActiveIngredient activeIngredient) {
        String query = "UPDATE activeIngredient SET administration_route = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, activeIngredient.getName());
            ps.setInt(2, activeIngredient.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("ActiveIngredient with ID " + activeIngredient.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update Administration Route with ID " + activeIngredient.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActiveIngredient deleteActiveIngredient(int id) {
        String query = "DELETE FROM activeIngredient WHERE id = ?";
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
    public Optional<ActiveIngredient> findActiveIngredientById(int id) {
        String query = "SELECT id, active_ingredient FROM activeIngredient WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        ActiveIngredient activeIngredient = new ActiveIngredient(rs.getInt("id"), rs.getString("administration_route"));
                        return Optional.of(activeIngredient);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public List<ActiveIngredient> findAllActiveIngredient() {
        String query = "SELECT id,administration_route FROM activeIngredient";
        List<ActiveIngredient> activeIngredients = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ActiveIngredient activeIngredient = new ActiveIngredient();
                    activeIngredient.setId(rs.getInt("id"));
                    activeIngredient.setName(rs.getString("administration_route"));
                    activeIngredients.add(activeIngredient);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return activeIngredients;
    }

    @Override
    public Optional<ActiveIngredient> findActiveIngredientByName(String name) {
        String query = "SELECT id, administration_route FROM activeIngredient WHERE administration_route = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ActiveIngredient activeIngredient = new ActiveIngredient(rs.getInt("id"), rs.getString("administration_route"));
                    return Optional.of(activeIngredient);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return Optional.empty();
    }

}
