package com.java.foodiecli.ui;

import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.validation.InputValidator;

public class Menu {
    public void displayMenu(){
          while(true){
              displayMenuHeader("WELCOME TO FOODIE APP");
              System.out.println();
              System.out.println("Please select an option !");
              System.out.println("--------------------------");
              System.out.println("1. Customer Section");
              System.out.println("2. Restaurant Section");
              System.out.println("3. Dishes Section");
              System.out.println("4. Order Section");
              System.out.println("5. Exit");
              System.out.println("Please enter your choice (1-5)");

              int input;
              input = Factory.getInputValidator().getValidMenuChoice();
              switch (input){
                  case 1 ->new CustomerMenu().displayCustomerMenu();
                  case 2 ->new RestaurantMenu().displayRestaurantsMenu();
                  case 3 ->new DishesMenu().displayDishesMenu();
                  case 4 ->new OrdersMenu().displayOrdersMenu();
                  case 5 ->{
                      System.out.println("Thanks for choosing Foodie App, See you again !");
                      System.exit(0);
                      break;
                  }
                  default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");
              }
          }
    }
    public void displayMenuHeader(String header) {
        printDishLine();
        String spaces = new String(new char[70]).replace('\0', ' ');
        System.out.format("%70s%10s%70s%n", spaces, header, spaces);
        printDishLine();
    }

    public void printDishLine() {
        String dishLine = new String(new char[150]).replace('\0', '-'); // Adjusted length to match the formatted output
        System.out.println(dishLine);
    }
}
