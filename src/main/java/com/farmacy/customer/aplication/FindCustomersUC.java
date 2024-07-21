package com.farmacy.customer.aplication;

import java.util.List;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class FindCustomersUC {
    private final CustomerService customerService;

    public FindCustomersUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> execute () {
        return customerService.findAllCustomers();
    }
}
