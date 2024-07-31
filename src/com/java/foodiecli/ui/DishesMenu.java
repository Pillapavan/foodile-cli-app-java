package com.java.foodiecli.ui;

import com.java.foodiecli.controller.DishController;
import com.java.foodiecli.exceptions.DishAlreadyExistsException;
import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Dish;

import java.util.List;
import java.util.Scanner;

public class DishesMenu extends Menu {
    private final DishController dishController;

    public DishesMenu() {
        this.dishController = Factory.getDishController();
    }


    public void displayDishesMenu() {
        while (true) {
            displayMenuHeader("WELCOME TO DISHES SECTION");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Add New Dish");
            System.out.println("2. View All Dish Items");
            System.out.println("3. Search Dish");
            System.out.println("4. Update Dish ");
            System.out.println("5. Delete Dish");
            System.out.println("6. Exit");

            System.out.println("Please enter your choice (1-6)");
            int input = Factory.getDishValidator().getValidDishesChoice();
            switch (input) {
                case 1 -> dishRegisterForm();
                case 2 -> displayAllDishes();
                case 3 -> searchDishForm();
                case 4 -> dishUpdatedForm();
                case 5 -> dishDeleteForm();
                case 6 -> {
                    System.out.println("Thank you , See you again !");
                    super.displayMenu();
                }
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-6)");
            }
        }
    }
    public void dishRegisterForm() {
        try {
            System.out.println("Please register entering the following details\n");
            String id = Factory.getRestaurantValidator().getVaildRestaurantId();
            String name = Factory.getCustomerValidator().getVaildCustomerName();
            String description = Factory.getDishValidator().getVaildDescription();
            double price = Factory.getDishValidator().getValidPrice();
            Dish dish = new Dish();
            dish.setDishId(id)
                    .setDishName(name)
                    .setDescription(description)
                    .setPrice(price);
            Dish savedDish = this.dishController.save(dish);
            System.out.println("Dish Register successfully");
            displayDishDetails(savedDish);

        } catch (DishAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayDishesMenu();
        }
    }

    public void displayDishDetails(Dish dish) {
        displayMenuHeader("Dishes");
        System.out.printf("%-10s%-30s%-80s%-30s%n", "id", "Name", "Description", "Price");
        printDishLine();
        System.out.printf("%-10s%-30s%-80s%-30s%n", dish.getDishId(), dish.getDishName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
    }

    public void displayAllDishes() {
        displayMenuHeader("Dishes");
        System.out.printf("%-10s%-30s%-80s%-30s%n", "id", "Name", "Description", "Price");
        printDishLine();
        List<Dish> dishList = this.dishController.getAllDishes();
        dishList.forEach(dish -> {
            System.out.printf("%-10s%-30s%-80s%-30s%n", dish.getDishId(), dish.getDishName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        });
    }

    public void searchDishForm() {
        try {
            System.out.println("Please enter the following details to search for dish\n");
            String id = Factory.getDishValidator().getVaildDishId();
            Dish dish = this.dishController.getDishById(id);
            displayDishDetails(dish);
        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayDishesMenu();
        }
    }

    public void dishUpdatedForm() {
        try {
            System.out.println("Please register entering the following details\n");
            String id = Factory.getRestaurantValidator().getVaildRestaurantId();
            String name = Factory.getCustomerValidator().getVaildCustomerName();
            String description = Factory.getDishValidator().getVaildDescription();
            double price = Factory.getDishValidator().getValidPrice();
            Dish dish = new Dish();
            dish.setDishId(id)
                    .setDishName(name)
                    .setDescription(description)
                    .setPrice(price);
            Dish updatedDish= this.dishController.updateDish(dish);
            System.out.println("Dish Updated Successfully");
             displayDishDetails(updatedDish);
        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayDishesMenu();
        }
    }
    public void dishDeleteForm(){
        try{
            System.out.println("Please enter the following details to delete the Customer\n");
            String id = Factory.getDishValidator().getVaildDishId();
            this.dishController.deleteDish(id);
            System.out.println("Customer Deleted Successfully");
        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Some internal error occurred. Please try again !");
            displayDishesMenu();
        }

    }

}
