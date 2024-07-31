package com.java.foodiecli.ui;

import com.java.foodiecli.controller.OrderController;
import com.java.foodiecli.exceptions.*;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Customer;
import com.java.foodiecli.model.Dish;
import com.java.foodiecli.model.Order;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.service.CustomerService;
import com.java.foodiecli.service.DishService;
import com.java.foodiecli.service.RestaurantService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrdersMenu extends Menu{
    private final OrderController orderController;

    public OrdersMenu() {
        this.orderController = Factory.getOrderController();
    }

    public void displayOrdersMenu() {
        while (true) {
            displayMenuHeader("WELCOME TO ORDERS SECTION");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Place New Order");
            System.out.println("2. Search Order");
            System.out.println("3. View All Orders");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice (1-4)");
            int input = Factory.getOrderValidator().getValidOrderChoice();
            switch (input) {
                case 1 -> newOrderForm();
                case 2 -> searchOrderForm();
                case 3 -> ordersList();
                case 4 -> {
                    System.out.println("Thank you , See you again !");
                    super.displayMenu();
                }
                default -> System.out.println("Invalid Input. Please enter the valid input from(1-4)");
            }
        }
    }

    private void ordersList() {
        List<Order> ordersList = this.orderController.getOrdersList();
        displayMenuHeader("All Order Details");
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n", "Id", "Customer Name", "Restaurant Name", "Items", "Order Date", "Price");
        printDishLine();
        ordersList.forEach(order -> {
            String dishNames = order.getDishes().stream().map(Dish::getDishName).collect(Collectors.joining(","));
            System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getOrderId(), order.getCustomer().getCustomerName(), order.getRestaurant().getRestaurantName(), dishNames, order.getOrderDate(), order.getTotalPrice());
        });
        System.out.println("\n\n");
    }

    private void searchOrderForm() {
        try{
            System.out.println("Please enter the following details to search for Order\n");
            String id = Factory.getOrderValidator().getVaildOrderId();
            Order order=this.orderController.getOrderById(id);
            displayOrderDetails(order);
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private void displayOrderDetails(Order order){
        String dishNames = order.getDishes().stream().map(Dish::getDishName).collect(Collectors.joining(","));
        displayMenuHeader("Order Details");
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n", "Id", "Customer Name", "Restaurant Name", "Items","Order Date","Price");
        printDishLine();
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getOrderId(), order.getCustomer().getCustomerName(), order.getRestaurant().getRestaurantName(), dishNames,order.getOrderDate(),String.format("$%.2f", order.getTotalPrice()));

    }

    private void newOrderForm(){
        Customer loggedInCustomer=null
                ;
        Restaurant restaurant=null;
        List<Dish> dishList=new ArrayList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            CustomerService customerService = Factory.getCustomerServiceImpl();
            RestaurantService restaurantService = Factory.getRestaurantService();
            DishService dishService = Factory.getDishService();
            loggedInCustomer = customerService.getCurrentLoggedInCustomer();
            if (loggedInCustomer != null) {
                System.out.println("Welcome MR/MS:" + loggedInCustomer.getCustomerName());
            }
            while (loggedInCustomer == null){
                System.out.println("Please login entering the following details\n");
                System.out.println("Enter email");
                String Email = scanner.nextLine();
                System.out.println("Enter password");
                String passWord = scanner.nextLine();
                Customer existingCustomer = customerService.validateCustomerLogin(Email,passWord);
                customerService.setCurrentLoggedInCustomer(existingCustomer);
                loggedInCustomer = customerService.getCurrentLoggedInCustomer();
                System.out.println("Welcome MR/MS:" + loggedInCustomer.getCustomerName());
            }
            String id=Factory.getOrderIdValidator().generateOrderId();
            while (restaurant == null) {
                new RestaurantMenu().displayAllRestaurants();
                printDishLine();
                System.out.println("Choose the Restaurant Id (Ex: R008 )");
                String restaurantId = Factory.getRestaurantValidator().getVaildRestaurantId();
                restaurant = restaurantService.getRestaurantById(restaurantId);
            }
            char addMoreItems='y';
            while (addMoreItems=='y'){
                new RestaurantMenu().displayMenuItems(restaurant.getRestaurantId());
                printDishLine();
                System.out.println("Enter the Dish Id (Ex : D001 )");
                String dishId=Factory.getDishValidator().getVaildDishId();
                Dish selectedDish = Factory.getDishService().getDishById(dishId);
                dishList.add(selectedDish);
                System.out.println("One Dish is added successfully : " + selectedDish.getDishName());
                System.out.println("Do you want to add more dishes (Y/N)");
                addMoreItems = scanner.nextLine().charAt(0);
            }
            double orderPrice=calculateOrderTotalPrice(dishList);
            LocalDate orderDate=LocalDate.now();

            Order order = new Order();
            order.setOrderId(id)
                    .setCustomer(loggedInCustomer)
                    .setRestaurant(restaurant)
                    .setDishes(dishList)
                    .setTotalPrice(orderPrice)
                    .setOrderDate(orderDate);

            Order placedOrder=this.orderController.save(order);
            if(placedOrder != null)
                System.out.println("Order Placed Successfully with the following details");

            displayOrderDetails(placedOrder);

        } catch (RestaurantNotFoundException | DishNotFoundException | OrderAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private double calculateOrderTotalPrice(List<Dish> dishList){
        return dishList.stream().mapToDouble(Dish::getPrice).sum();
    }
}
