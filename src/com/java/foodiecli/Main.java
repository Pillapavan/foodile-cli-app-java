package com.java.foodiecli;

import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.repository.RestaurantRepository;
import com.java.foodiecli.service.RestaurantServiceImpl;
import com.java.foodiecli.ui.CustomerMenu;
import com.java.foodiecli.ui.Menu;
import com.java.foodiecli.util.CsvReader;
import com.java.foodiecli.validation.CustomerValidator;

public class Main {
    public static void main(String[] args) {

        Menu menu=new Menu();
        menu.displayMenu();

    }

}
