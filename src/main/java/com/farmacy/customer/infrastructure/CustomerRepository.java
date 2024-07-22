package com.farmacy.customer.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class CustomerRepository implements CustomerService{
    private Connection connection;
    
    public CustomerRepository(){
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
    public void createCustomer(Customer customer) {
        String query = "INSERT INTO customers (id,doctype,name,lastname,birthdate,neighborhood) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getId());
            ps.setInt(2, customer.getDocType());
            ps.setString(3, customer.getName());
            ps.setString(4, customer.getLastName());
            ps.setString(5, customer.getBirthdate());
            ps.setInt(6, customer.getIdNeighborhood());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hola soy un hp error");
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customers SET doctype = ?,name = ?,lastname = ?,birthdate = ?,neighborhood = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, customer.getDocType());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getBirthdate());
            ps.setInt(5, customer.getIdNeighborhood());
            ps.setString(6, customer.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.addSuppressed(e);
        }
    }

    @Override
    public Customer deleteCustomer(String id) {
        String query = "DELETE FROM customers WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hola, soy un hp error");
        }
        return null;
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        String query = "SELECT id,doctype,name,lastname,age,birthdate,registerdate,neighborhood FROM customers WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setDocType(rs.getInt("doctype"));
                customer.setName(rs.getString("name"));
                customer.setLastName(rs.getString("lastname"));
                customer.setAge(rs.getInt("age"));
                customer.setBirthdate(rs.getString("birthdate"));
                customer.setRegdate(rs.getString("registerdate"));
                customer.setIdNeighborhood(rs.getInt("neighborhood"));
                
                return Optional.of(customer);

            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> findAllCustomers() {
        String query = "SELECT id,doctype,name,lastname,age,birthdate,registerdate,neighborhood FROM customers";
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setDocType(rs.getInt("doctype"));
                customer.setName(rs.getString("name"));
                customer.setLastName(rs.getString("lastname"));
                customer.setAge(rs.getInt("age"));
                customer.setBirthdate(rs.getString("birthdate"));
                customer.setRegdate(rs.getString("registerdate"));
                customer.setIdNeighborhood(rs.getInt("neighborhood"));
                customers.add(customer);
            }

        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return customers;
    }

    @Override
    public Optional<Customer> findCustomerByName(String name) {
        String query = "SELECT id,doctype,name,lastname,age,birthdate,registerdate,neighborhood FROM customers WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setDocType(rs.getInt("doctype"));
                customer.setName(rs.getString("name"));
                customer.setLastName(rs.getString("lastname"));
                customer.setAge(rs.getInt("age"));
                customer.setBirthdate(rs.getString("birthdate"));
                customer.setRegdate(rs.getString("registerdate"));
                customer.setIdNeighborhood(rs.getInt("neighborhood"));

                return Optional.of(customer);
            }
        } catch (Exception e) {
            e.addSuppressed(e);
        }
        return Optional.empty();
    }
    
}
