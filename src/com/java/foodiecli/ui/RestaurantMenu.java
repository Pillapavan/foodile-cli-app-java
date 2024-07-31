package com.java.foodiecli.ui;

import com.java.foodiecli.controller.RestaurantController;
import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.exceptions.RestaurantNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Customer;
import com.java.foodiecli.model.Dish;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.service.RestaurantService;

import java.util.List;

public class RestaurantMenu extends Menu {
    private final RestaurantController restaurantController;

    public RestaurantMenu() {
        this.restaurantController = Factory.getRestaurantController();
    }

    public void displayRestaurantsMenu() {
        try {
            while (true) {
                displayMenuHeader("WELCOME TO RESTAURANT SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add New Restaurant");
                System.out.println("2. View All Restaurants");
                System.out.println("3. Search Restaurant");
                System.out.println("4. Update Restaurant ");
                System.out.println("5. Delete Restaurant");
                System.out.println("6. Exit");

                System.out.println("Please enter your choice (1-6)");

                int input = Factory.getRestaurantValidator().getValidRestaurantChoice();
                switch (input) {
                    case 1 -> restaurantRegisterForm();
                    case 2 -> displayAllRestaurants();
                    case 3 -> restaurantSearchForm();
                    case 4 -> updateRestaurantForm();
                    case 5 -> deleteRestaurant();
                    case 6 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMenu();
                    }
                }
            }
        }catch(Exception e){
                System.out.println("Invalid Input. Please enter the valid input from(1-6)");
                displayRestaurantsMenu();
            }
        }


    public void restaurantRegisterForm() {
        try {
            System.out.println("Please register entering the following details\n");
            String id = Factory.getRestaurantValidator().getVaildRestaurantId();
            String name = Factory.getRestaurantValidator().getVaildRestaurantName();
            String address = Factory.getRestaurantValidator().getVaildRestaurantAddress();
            List<String> menu = Factory.getRestaurantValidator().getValidRestaurantMenu();
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId(id)
                    .setRestaurantName(name)
                    .setAddress(address)
                    .setMenu(menu);
            Restaurant savedRestaurant = this.restaurantController.save(restaurant);
            displayRestaurabtDetails(savedRestaurant);
            System.out.println();
            System.out.println("Customer Registration Successful");
            displayRestaurantsMenu();

        } catch (RestaurantAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            displayRestaurantsMenu();
        }

    }

    public void displayRestaurabtDetails(Restaurant restaurant) {
        displayMenuHeader("Restaurant Details:");
        System.out.printf("%-20s%-40s%-50s%-40s%n", "ID", "Name", "Address", "Menu");
        printDishLine();
        System.out.printf("%-20s%-40s%-50s%-40s%n", restaurant.getRestaurantId(), restaurant.getRestaurantName(), restaurant.getAddress(), restaurant.getMenu());
    }

    public void displayAllRestaurants() {
        List<Restaurant> restaurants = this.restaurantController.getAllRestaurants();
        displayMenuHeader("Restaurants Details");
        System.out.printf("%-10s%-40s%-60s%-40s%n", "ID", "Name", "Address", "Menu");
        printDishLine();
        restaurants.forEach(restaurant -> {
            System.out.printf("%-10s%-40s%-60s%-40s%n", restaurant.getRestaurantId(), restaurant.getRestaurantName(), restaurant.getAddress(), restaurant.getMenu());
        });
    }

    public void restaurantSearchForm() {
        try {
        System.out.println("Please enter the following details to search for Restaurant\n");
        String id = Factory.getRestaurantValidator().getVaildRestaurantId();
            Restaurant restaurant = this.restaurantController.getRestaurantById(id);
            displayRestaurabtDetails(restaurant);
        } catch (RestaurantNotFoundException e) {
            System.out.println(e.getMessage());
            displayRestaurantsMenu();
        }
    }
    public  void updateRestaurantForm(){
        try{
            System.out.println("Please Update entering the following details\n");
            String id = Factory.getRestaurantValidator().getVaildRestaurantId();
            String name = Factory.getRestaurantValidator().getVaildRestaurantName();
            String address = Factory.getRestaurantValidator().getVaildRestaurantAddress();
            List<String> menu = Factory.getRestaurantValidator().getValidRestaurantMenu();
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId(id)
                    .setRestaurantName(name)
                    .setAddress(address)
                    .setMenu(menu);
            Restaurant updatedRestaurant=this.restaurantController.updateRestaurant(restaurant);
            System.out.println("Restaurant Updated Successfully");
            displayRestaurabtDetails(restaurant);
        } catch (RestaurantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
     public void deleteRestaurant(){
         System.out.println("Please enter the following details to delete the Restaurant\n");
         try{
             String id = Factory.getRestaurantValidator().getVaildRestaurantId();
             this.restaurantController.deleteRestaurant(id);
             System.out.println("Restaurant Deleted Successfully");
         } catch (RestaurantNotFoundException e) {
             System.out.println(e.getMessage());
         }
     }
    public void displayMenuItems(String restaurantId) throws RestaurantNotFoundException, DishNotFoundException {
        displayMenuHeader("Dishes Menu Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDishLine();
        RestaurantService restaurantService = Factory.getRestaurantService();
        List<Dish> dishItems = restaurantService.getDishItems(restaurantId);
        for (Dish dish : dishItems) {
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getDishId(), dish.getDishName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        }
    }
}