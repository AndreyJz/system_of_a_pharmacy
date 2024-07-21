package com.farmacy.customer.aplication;

import com.farmacy.customer.domain.service.CustomerService;

public class DeleteCustomerUC {
    private final CustomerService customerService;

    public DeleteCustomerUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute (String id) {
        customerService.deleteCustomer(id);
    }
}
