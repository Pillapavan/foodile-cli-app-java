package com.java.foodiecli.controller;

import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.exceptions.CustomerNotFoundException;
import com.java.foodiecli.model.Customer;
import com.java.foodiecli.service.CustomerService;
import com.java.foodiecli.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    public Customer save(Customer customer) throws CustomerAlreadyExistsException{
        return this.customerServiceImpl.save(customer);
    }
    public Customer validateCustomerLogin(String Email,String passWord) throws CustomerNotFoundException{
        return this.customerServiceImpl.validateCustomerLogin(Email,passWord);
    }
    public Customer getCustomerById(String Id) throws CustomerNotFoundException{
        return  this.customerServiceImpl.getCustomerById(Id);
    }
    public List<Customer> getAllCustomers(){
        return this.customerServiceImpl.getAllCustomers();
    }
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
        return this.customerServiceImpl.updateCustomer(customer);
    }
    public void deleteCustomer(String id) throws CustomerNotFoundException{
        this.customerServiceImpl.deleteCustomer(id);
    }
}
