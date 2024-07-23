package com.farmacy.unitofmeasure.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;
import com.farmacy.unitofmeasure.domain.service.UnitOfMeasureService;

public class UnitOfMeasureRepository implements UnitOfMeasureService {
    private Connection connection;

    public UnitOfMeasureRepository(){
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
    public void createUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        try {
            String query = "INSERT INTO unitsOfMeasure (unit_of_measure) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, unitOfMeasure.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void updateUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        String query = "UPDATE unitsOfMeasure SET unit_of_measure = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, unitOfMeasure.getName());
            ps.setInt(2, unitOfMeasure.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Unit Of Measure with ID " + unitOfMeasure.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update Unit Of Measure with ID " + unitOfMeasure.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UnitOfMeasure deleteUnitOfMeasure(int id) {
        String query = "DELETE FROM unitsOfMeasure WHERE id = ?";
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
    public Optional<UnitOfMeasure> findUnitOfMeasureById(int id) {
        String query = "SELECT id, unit_of_measure FROM unitsOfMeasure WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        UnitOfMeasure unitOfMeasure = new UnitOfMeasure(rs.getInt("id"), rs.getString("unit_of_measure"));
                        return Optional.of(unitOfMeasure);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public List<UnitOfMeasure> findAllUnitOfMeasure() {
        String query = "SELECT id, unit_of_measure FROM unitsOfMeasure";
        List<UnitOfMeasure> unitOfMeasures = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
                    unitOfMeasure.setId(rs.getInt("id"));
                    unitOfMeasure.setName(rs.getString("unit_of_measure"));
                    unitOfMeasures.add(unitOfMeasure);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return unitOfMeasures;
    }

    @Override
    public Optional<UnitOfMeasure> findUnitOfMeasureByName(String name) {
        String query = "SELECT id, unit_of_measure FROM unitsOfMeasure WHERE unit_of_measure = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UnitOfMeasure unitOfMeasure = new UnitOfMeasure(rs.getInt("id"), rs.getString("unit_of_measure"));
                    return Optional.of(unitOfMeasure);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return Optional.empty();
    }

}
