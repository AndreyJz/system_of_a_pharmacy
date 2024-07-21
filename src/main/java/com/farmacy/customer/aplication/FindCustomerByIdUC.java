package com.farmacy.customer.aplication;

import java.util.Optional;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class FindCustomerByIdUC {
    private final CustomerService customerService;

    public FindCustomerByIdUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<Customer> execute (String id) {
        return customerService.findCustomerById(id);
    }
}
