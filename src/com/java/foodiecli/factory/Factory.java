package com.java.foodiecli.factory;

import com.java.foodiecli.controller.CustomerController;
import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.repository.CustomerRepository;
import com.java.foodiecli.service.CustomerServiceImpl;
import com.java.foodiecli.ui.CustomerMenu;
import com.java.foodiecli.ui.Menu;
import com.java.foodiecli.util.CsvReader;
import com.java.foodiecli.validation.CustomerValidator;
import com.java.foodiecli.validation.InputValidator;

//This approach is called Bill Pugh Singleton
public class Factory {

    public static CsvReader getCsvReader() {
        return Header.CSV_READER;
    }

    public static CustomerRepository getCustomerRespository() {
        return Header.CUSTOMER_REPOSITORY;
    }

    public static CustomerServiceImpl getCustomerServiceImpl() {
        return Header.CUSTOMER_SERVICE;
    }

    public static CustomerController getCustomerController() {
        return Header.CUSTOMER_CONTROLLER;
    }
    public static InputValidator getInputValidator(){
        return Header.INPUT_VALIDATOR;
    }
    public static CustomerValidator getCustomerValidator(){
        return Header.CUSTOMER_VALIDATOR;
    }
    public  static CustomerMenu getCustomerMenu(){
        return Header.CUSTOMER_MENU;
    }

    public static class Header {
        private final static CsvReader CSV_READER = new CsvReader();

        private final static CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();
        private final static CustomerServiceImpl CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY);
        private final static CustomerController CUSTOMER_CONTROLLER = new CustomerController(CUSTOMER_SERVICE);

        private final static InputValidator INPUT_VALIDATOR=new InputValidator();
        private final static CustomerValidator CUSTOMER_VALIDATOR=new CustomerValidator();
        private final static CustomerMenu CUSTOMER_MENU=new CustomerMenu();


    }
}
