package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.exceptions.CustomerNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Customer;
import com.java.foodiecli.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private Customer CurrentLoggedInCustomer;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository= customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerAlreadyExistsException {
        Optional<Customer> ifCustomerExists = this.customerRepository.getCustomerById(customer.getCustomerId());
        if (ifCustomerExists.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer Already exists with  this Email: " + customer.getCustomerId());
        }
        return this.customerRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getCustomerList();
    }

    @Override
    public Customer validateCustomerLogin(String Email, String passWord) throws CustomerNotFoundException {
        Optional<Customer> validLogin = this.customerRepository.getCustomerByEmailAndPassword(Email,passWord);
        if (validLogin.isEmpty()) {
            throw new CustomerNotFoundException("Invalid Email or Password");
        }
        return validLogin.get();
    }

    @Override
    public Customer getCustomerById(String Id) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer=this.customerRepository.getCustomerById(Id);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer Not found with this ID");
        }
        return optionalCustomer.get();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
            Optional<Customer> optionalCustomer=this.customerRepository.getCustomerById(customer.getCustomerId());
            if (optionalCustomer.isEmpty()){
                throw new CustomerNotFoundException("Customer is not Found with this Id"+customer.getCustomerId());
            }
       return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer=this.customerRepository.getCustomerById(id);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer is not Found"+id);
        }
        this.customerRepository.deleteCustomer(optionalCustomer.get());
    }

    @Override
    public void setCurrentLoggedInCustomer(Customer customer) {
        this.CurrentLoggedInCustomer=customer;
    }

    @Override
    public Customer getCurrentLoggedInCustomer() {
        return this.CurrentLoggedInCustomer;
    }

}
