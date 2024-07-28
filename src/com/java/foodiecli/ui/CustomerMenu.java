package com.java.foodiecli.ui;

import com.java.foodiecli.controller.CustomerController;
import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.exceptions.CustomerNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomerMenu extends Menu {
    private final CustomerController customerController;

    public CustomerMenu() {
        this.customerController = Factory.getCustomerController();
    }

    public void displayCustomerMenu() {
        while (true) {
            displayMenuHeader("WELCOME TO CUSTOMER SECTION");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Register (New Customer)");
            System.out.println("2. Login  (Existing Customer)");
            System.out.println("3. Search Customer");
            System.out.println("4. Display All Customers ");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Exit");
            int input = Factory.getCustomerValidator().getValidCustomerChoice();
            switch (input) {
                case 1 -> customerRegisterForm();
                case 2 -> customerLoginform();
                case 3 -> customerSearchForm();
                case 4 -> displayAllCustomers();
                case 5 -> updateCustomerForm();
                case 6 -> deleteCustomer();
                case 7 -> {
                    System.out.println("Thank you , See you again !");
                    super.displayMenu();
                }
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");
            }
        }
    }

    public void customerRegisterForm() {

        boolean registrationSuccessful = false;
        Scanner scanner = new Scanner(System.in);
        while (!registrationSuccessful) {
            try {
                System.out.println("Please register entering the following details\n");
                String id = Factory.getCustomerValidator().getVaildCustomerId();
                String name = Factory.getCustomerValidator().getVaildCustomerName();
                String email = Factory.getCustomerValidator().getVaildCustomerEmail();
                String password = Factory.getCustomerValidator().getVaildCustomerPassword();
                Customer customer = new Customer();
                customer.setCustomerId(id)
                        .setCustomerName(name)
                        .setEmail(email)
                        .setPassword(password);
                Customer savedCustomer = customerController.save(customer);

                displayCustomerDetails(savedCustomer);
                registrationSuccessful = true;
                System.out.println();
                System.out.println("Customer Registration Successful");
                displayCustomerMenu();

            } catch (CustomerAlreadyExistsException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Some internal error occurred. Please try again !");
                customerRegisterForm();
            }
        }
    }

    public void displayCustomerDetails(Customer customer) {
        displayMenuHeader("Customer Details");
        System.out.format("%-10s%-40s%-60s%-40s%n", "Id", "Name", "Email", "Password");
        printDishLine();
        System.out.format("%-10s%-40s%-60s%-40s%n", customer.getCustomerId(), customer.getCustomerName(), customer.getEmail(), customer.getPassword());
    }

    public void customerLoginform() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please login entering the following details\n");
            System.out.println("Enter email");
            String Email = sc.nextLine();
            System.out.println("Enter password");
            String passWord = sc.nextLine();
            Customer existingCustomer = customerController.validateCustomerLogin(Email, passWord);
            System.out.println("Login Success :");
            System.out.println("Welcome Mr : " + existingCustomer.getCustomerName());
            super.displayMenu();
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            displayCustomerMenu();
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            customerLoginform();
        }

    }

    public void customerSearchForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Customer\n");
            System.out.println("Enter Id");
            String Id = scanner.nextLine();
            Customer customer = customerController.getCustomerById(Id);
            displayCustomerDetails(customer);
            displayCustomerMenu();
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            displayCustomerMenu();
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            customerSearchForm();
        }
    }

    public void displayAllCustomers() {
        List<Customer> customer = this.customerController.getAllCustomers();
        displayMenuHeader("Customer");
        System.out.printf("%10s %30s %80s %30s\n", "Id", "Name", "Email", "Password");
        super.printDishLine();
        customer.forEach(customer1 ->
        {
            System.out.printf("%10s %30s %80s %30s\n", customer1.getCustomerId(), customer1.getCustomerName(), customer1.getEmail(), customer1.getPassword());
        });
    }

    public void updateCustomerForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Update entering the following details\n");
            System.out.println("Enter Your Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            Customer customer = new Customer();
            customer.setCustomerId(id)
                    .setCustomerName(name)
                    .setEmail(email)
                    .setPassword(password);
            Customer updatedCustomer = customerController.updateCustomer(customer);
            System.out.println("Customer Updated Successfully");
            displayCustomerDetails(updatedCustomer);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
        }
    }
    public void deleteCustomer(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            customerController.deleteCustomer(id);
            System.out.println("Customer Deleted Successfully");
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
        }
    }
}