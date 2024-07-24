package com.java.foodiecli.repository;

import com.java.foodiecli.model.Customer;
import com.java.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private List<Customer> customerList;

    public CustomerRepository(){
        CsvReader csvReader=new CsvReader();
        this.customerList=csvReader.readCustomerFromCsv();
    }
    public Customer saveCustomer(Customer customer){
        this.customerList.add(customer);
        return customer;
    }
    public Optional<Customer> getCustomerById(String id){
        return  this.customerList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }
}
