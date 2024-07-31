package com.java.foodiecli.validation;


import com.java.foodiecli.factory.Factory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerValidator {
    public int getValidCustomerChoice() {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
                input = sc.nextInt();
                if (input >= 1 && input <= 7) {

                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
        }
        return input;
    }

    public String getVaildCustomerId() {
        System.out.println("Enter id(At least 3 numbers):");
        Scanner sc = new Scanner(System.in);
        String id = "";
        boolean validId = false;
            while (!validId) {
                id = sc.nextLine();
                if (id != null && id.matches("\\d{3,}")) {
                    validId = true;
                    if (id.charAt(0)!='C') {
                        id = "C" + id;
                    }
                } else {
                    System.out.println("Invalid id. Please enter an id with at least 3 numbers.");
                }
            }
        return id;
    }

    public String getVaildCustomerName() {
        System.out.println("Enter Name(At least 5 Characters):");
        Scanner sc = new Scanner(System.in);
        String Name = "";
        String regex = "[a-zA-Z\\s'-]+";
        boolean validName = false;
            while (!validName) {
                Name = sc.nextLine();
                if (Name != null && Name.length() >= 5 && Name.length() <= 30 && Name.matches(regex)) {
                    validName = true;
                    Name = Name.trim();

                } else {
                    System.out.println("Invalid Name. Please enter a Name with at least 5 Characters.");
                }
            }
        return Name;
    }

    public String getVaildCustomerEmail() {
        System.out.println("Enter Email");
        Scanner sc = new Scanner(System.in);
        String Email = "";
        boolean validGmail = false;
        String regex = "^[a-zA-Z0-9]+@gmail.com$";
            while (!validGmail) {
                Email = sc.nextLine();
                if (Email != null && Email.length() >= 8 && Email.length() <= 30 && Email.matches(regex)) {
                    validGmail = true;
                    Email = Email.trim();

                } else {
                    System.out.println("Invalid Email. Please enter a gmail with at least 8 Characters");
                }
            }
        return Email;
    }

    public String getVaildCustomerPassword() {
        System.out.println("Enter Password");
        Scanner sc = new Scanner(System.in);
        String password = "";
        boolean validPassword = false;
            while (!validPassword) {
                password = sc.nextLine();
                // Password must be between 8 and 20 characters long,
                // contain at least one digit, one lowercase letter, one uppercase letter, and one special character.
                if (password != null &&
                        password.length() >= 8 &&
                        password.length() <= 20 &&
                        password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()\\[\\]<>?*-+~`]).{8,20}$")) {
                    validPassword = true;
                } else {
                    System.out.println("Invalid Password. Please enter a password with 8-20 characters, including at least one digit, one uppercase letter, one lowercase letter, and one special character.");
                }
            }
        return password;
    }
}
