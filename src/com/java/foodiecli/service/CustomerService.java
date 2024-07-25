package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerAlreadyExistsException;

    public List<Customer> getAllCustomers();
}
