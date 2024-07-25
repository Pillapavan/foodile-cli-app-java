package com.java.foodiecli.controller;

import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.model.Customer;
import com.java.foodiecli.service.CustomerService;
import com.java.foodiecli.service.CustomerServiceImpl;

public class CustomerController {
    private CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    public Customer save(Customer customer) throws CustomerAlreadyExistsException{
        return this.customerServiceImpl.save(customer);
    }
}
