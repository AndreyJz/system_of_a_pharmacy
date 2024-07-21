package com.farmacy.customer.aplication;

import java.util.Optional;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class FindCustomerByNameUC {
    private final CustomerService customerService;

    public FindCustomerByNameUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<Customer> execute (String name){
        return customerService.findCustomerByName(name);
    }
}
