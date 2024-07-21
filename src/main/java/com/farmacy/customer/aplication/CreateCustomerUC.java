package com.farmacy.customer.aplication;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class CreateCustomerUC {
    private final CustomerService customerService;

    public CreateCustomerUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer) {
        customerService.createCustomer(customer);
    }
}
