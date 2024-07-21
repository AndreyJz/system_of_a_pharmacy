package com.farmacy.idtype.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.idtype.domain.service.IdTypeService;

public class IdTypeRepository implements IdTypeService {
    private Connection connection;

    public IdTypeRepository(){
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
    public void createIdType(IdType idType) {
        try {
            String query = "INSERT INTO idtypes (doc) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, idType.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("hola soy un hp error");
            e.printStackTrace();
        }
    }

    @Override
    public void updateIdType(IdType idType) {
        String query = "UPDATE idtypes SET doc = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, idType.getName());
            ps.setInt(2, idType.getId());
            
            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("IdType with ID " + idType.getId() + " updated successfully.");
            } else {
                System.out.println("Failed to update country with ID " + idType.getId() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IdType deleteIdType(int id) {
        String query = "DELETE FROM idtypes WHERE id = ?";
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
    public Optional<IdType> findIdTypeById(int id) {
        String query = "SELECT id, doc FROM idtypes WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        IdType idType = new IdType(rs.getInt("id"), rs.getString("doc"));
                        return Optional.of(idType);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public List<IdType> findAllIdType() {
        String query = "SELECT id,doc FROM idtypes";
        List<IdType> idtypes = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    IdType idType = new IdType();
                    idType.setId(rs.getInt("id"));
                    idType.setName(rs.getString("doc"));
                    idtypes.add(idType);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return idtypes;
    }

    @Override
    public Optional<IdType> findIdTypeByName(String name) {
        String query = "SELECT id, doc FROM idtypes WHERE doc = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    IdType idType = new IdType(rs.getInt("id"), rs.getString("doc"));
                    return Optional.of(idType);
                }
            }
        } catch (Exception e) {
            e.addSuppressed(e);
            System.out.println("hola soy un hp error");
        }
        return Optional.empty();
    }

}
