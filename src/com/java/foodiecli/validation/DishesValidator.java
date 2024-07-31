package com.java.foodiecli.validation;

import java.util.Scanner;

public class DishesValidator {
    public int getValidDishesChoice() {
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
    public String getVaildDishId() {
        System.out.println("Enter id(At least 3 numbers):");
        Scanner sc = new Scanner(System.in);
        String id = "";
        boolean validId = false;
        while (!validId) {
            id = sc.nextLine();
            if (id != null && id.matches("\\d{3,}")) {
                validId = true;
                if(id.charAt(0)!='D') {
                    id = "D" + id;
                }
            } else {
                System.out.println("Invalid id. Please enter an id with at least 3 numbers.");
            }
        }
        return id;
    }
    public String getVaildDishName() {
        System.out.println("Enter Dish Name(At least 5 Characters):");
        Scanner sc = new Scanner(System.in);
        String Name = "";
        String regex = "[a-zA-Z\\s]+";
        boolean validName = false;
        while (!validName) {
            Name = sc.nextLine();
            if (Name != null && Name.length() >= 5 && Name.length() <= 30 && Name.matches(regex)) {
                validName = true;
                Name = Name.trim();

            } else {
                System.out.println("Invalid Dish Name. Please enter a Name with at least 5 Characters.");
            }
        }
        return Name;
    }
    public String getVaildDescription() {
        System.out.println("Enter Description:");
        Scanner sc = new Scanner(System.in);
        String Description = "";
        String regex = "[a-zA-Z\\s'-_,]+";
        boolean validName = false;
        while (!validName) {
            Description = sc.nextLine();
            if (Description != null && Description.length() >= 5 && Description.length() <= 50 && Description.matches(regex)) {
                validName = true;
                Description = Description.trim();

            } else {
                System.out.println("Invalid Name. Please enter a Name with at least 5 Characters.");
            }
        }
        return Description;
    }
    public double getValidPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Price:");
        double price = 0;
        boolean validPrice = false;
        while (!validPrice){
            price = sc.nextDouble();
            if (price>0){
                validPrice=true;
            }
            else{
                System.out.println("Invalid price.Please enter a price with only two decimal points");
            }

        }
        return price;
    }
}
