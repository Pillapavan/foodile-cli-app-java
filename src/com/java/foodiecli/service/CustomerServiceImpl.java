package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.model.Customer;
import com.java.foodiecli.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerAlreadyExistsException {
        Optional<Customer> ifCustomerExists=this.customerRepository.getCustomerById(customer.getCustomerId());
        if(ifCustomerExists.isPresent()){
            throw new CustomerAlreadyExistsException("Customer Already exists with  this id"+customer.getCustomerId());
        }
        return this.customerRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getCustomerList();
    }

}
