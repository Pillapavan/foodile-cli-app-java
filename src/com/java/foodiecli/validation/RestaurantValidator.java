package com.java.foodiecli.validation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RestaurantValidator {
    public int getValidRestaurantChoice() {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
                input = sc.nextInt();
                if (input >= 1 && input <= 6) {

                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
        }
        return input;
    }
    public String getVaildRestaurantId() {
        System.out.println("Enter id(At least 3 numbers):");
        Scanner sc = new Scanner(System.in);
        String id = "";
        boolean validId = false;
        while (!validId) {
            id = sc.nextLine();
            if (id != null && id.matches("\\d{3,}")) {
                validId = true;
                if (id.charAt(0)!='R') {
                    id = "R" + id;
                }
            } else {
                System.out.println("Invalid id. Please enter an id with at least 3 numbers.");
            }
        }
        return id;
    }
    public String getVaildRestaurantName() {
        System.out.println("Enter Name(At least 5 Characters):");
        Scanner sc = new Scanner(System.in);
        String Name = "";
        String regex = "[a-zA-Z\\s'-_]+";
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
    public String getVaildRestaurantAddress() {
        System.out.println("Enter Address:");
        Scanner sc = new Scanner(System.in);
        String address = "";
        String regex = "[a-zA-Z\\s',-/]+";
        boolean validName = false;
        while (!validName) {
            address = sc.nextLine();
            if (address != null && address.length() >= 5 && address.length() <= 30 && address.matches(regex)) {
                validName = true;
                address = address.trim();

            } else {
                System.out.println("Invalid Address. Please enter address with at least 5 Characters.");
            }
        }
        return address;
    }
    public List<String> getValidRestaurantMenu() {
        List<String> menu = new ArrayList<>();
        System.out.println("Enter MenuIds (Like D001:D002)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String OverAllPattern = "^D\\d{2,}(?::D\\d{2,})*$";
            if (!Pattern.matches(OverAllPattern, input)) {
                System.out.println("Please Enter Correct MenuId's");
                getValidRestaurantMenu();
            } else {
                String[] items = input.split(":");
                for (String item : items) {
                    menu.add(item);
                }
            }
    return menu;
    }


}
