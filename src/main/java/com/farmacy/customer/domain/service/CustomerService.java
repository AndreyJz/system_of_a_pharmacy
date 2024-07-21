package com.farmacy.customer.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.customer.domain.entity.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer deleteCustomer(String id);
    Optional<Customer> findCustomerById(String id);
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerByName(String name);
}
