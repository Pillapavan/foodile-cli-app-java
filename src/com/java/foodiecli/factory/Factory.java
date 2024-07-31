package com.java.foodiecli.factory;

import com.java.foodiecli.controller.CustomerController;
import com.java.foodiecli.controller.DishController;
import com.java.foodiecli.controller.OrderController;
import com.java.foodiecli.controller.RestaurantController;
import com.java.foodiecli.exceptions.CustomerAlreadyExistsException;
import com.java.foodiecli.model.Order;
import com.java.foodiecli.repository.CustomerRepository;
import com.java.foodiecli.repository.DishRepository;
import com.java.foodiecli.repository.OrderRespository;
import com.java.foodiecli.repository.RestaurantRepository;
import com.java.foodiecli.service.CustomerServiceImpl;
import com.java.foodiecli.service.DishServiceImpl;
import com.java.foodiecli.service.OrderServiceImpl;
import com.java.foodiecli.service.RestaurantServiceImpl;
import com.java.foodiecli.ui.CustomerMenu;
import com.java.foodiecli.ui.Menu;
import com.java.foodiecli.ui.RestaurantMenu;
import com.java.foodiecli.util.CsvReader;
import com.java.foodiecli.validation.*;

//This approach is called Bill Pugh Singleton
public class Factory {

    public static CsvReader getCsvReader() {
        return Header.CSV_READER;
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
    public static RestaurantServiceImpl getRestaurantService(){
        return Header.RESTAURANT_SERVICE;
    }
    public static RestaurantController getRestaurantController(){
        return Header.RESTAURANT_CONTROLLER;
    }
    public static RestaurantValidator getRestaurantValidator(){
        return Header.RESTAURANT_VALIDATOR;
    }
    public static RestaurantMenu getRestaurantMenu(){
        return Header.RESTAURANT_MENU;
    }
    public static DishController getDishController(){
        return  Header.DISH_CONTROLLER;
    }
    public static DishServiceImpl getDishService(){
        return  Header.DISH_SERVICE;
    }
    public static DishesValidator getDishValidator(){
        return Header.DISHES_VALIDATOR;
    }
    public static OrderServiceImpl getOrderService(){
        return Header.ORDER_SERVICE;
    }
    public static OrderController getOrderController(){
        return Header.ORDER_CONTROLLER;
    }
    public static OrderValidator getOrderValidator(){
        return Header.ORDER_VALIDATOR;
    }
    public static OrderIdValidator getOrderIdValidator(){
        return Header.ORDER_ID_VALIDATOR;
    }
    public static class Header {
        private final static CsvReader CSV_READER = new CsvReader();

        private final static CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();
        private final static CustomerServiceImpl CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY);
        private final static CustomerController CUSTOMER_CONTROLLER = new CustomerController(CUSTOMER_SERVICE);

        private final static RestaurantRepository RESTAURANT_REPOSITORY=new RestaurantRepository();
        private final static RestaurantServiceImpl RESTAURANT_SERVICE=new RestaurantServiceImpl(RESTAURANT_REPOSITORY);
        private final static RestaurantController RESTAURANT_CONTROLLER=new RestaurantController(RESTAURANT_SERVICE);

        private final static InputValidator INPUT_VALIDATOR=new InputValidator();
        private final static CustomerValidator CUSTOMER_VALIDATOR=new CustomerValidator();
        private final static CustomerMenu CUSTOMER_MENU=new CustomerMenu();

        private final static RestaurantValidator RESTAURANT_VALIDATOR= new RestaurantValidator();
        private final static RestaurantMenu RESTAURANT_MENU=new RestaurantMenu();

        private final static DishRepository DISH_REPOSITORY=new DishRepository();
        private final static DishServiceImpl DISH_SERVICE=new DishServiceImpl(DISH_REPOSITORY);
        private final static DishController DISH_CONTROLLER=new DishController(DISH_SERVICE);
        private final static DishesValidator DISHES_VALIDATOR=new DishesValidator();

        private final static OrderRespository ORDER_RESPOSITORY=new OrderRespository();
        private final static OrderServiceImpl ORDER_SERVICE=new OrderServiceImpl(ORDER_RESPOSITORY);
        private final static OrderController ORDER_CONTROLLER=new OrderController(ORDER_SERVICE);


        private final static OrderValidator ORDER_VALIDATOR=new OrderValidator();
        private final static OrderIdValidator ORDER_ID_VALIDATOR=new OrderIdValidator();

    }
}
