package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.exceptions.CustomerNotFoundException;
import com.java.foodiecli.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerAlreadyExistsException;

    public List<Customer> getAllCustomers();

    public Customer validateCustomerLogin(String Email,String passWord) throws CustomerNotFoundException;
    public Customer getCustomerById(String Id) throws CustomerNotFoundException;
    public Customer updateCustomer(Customer customerToBeUpdated) throws CustomerNotFoundException;
    public void deleteCustomer(String id) throws CustomerNotFoundException;
}
