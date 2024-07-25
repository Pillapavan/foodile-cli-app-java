package com.java.foodiecli.repository;

import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.exceptions.RestaurantNotFoundException;
import com.java.foodiecli.model.Customer;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.util.CsvReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantRepository {
    private  List<Restaurant> restaurantList;

    public RestaurantRepository() {
        CsvReader csvReader=new CsvReader();
        this.restaurantList=csvReader.readRestaurantsFromCsv();

    }
    public Restaurant saveRestaurant(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        return restaurant;
    }
    public Optional<Restaurant> getRestaurantById(String id) {
      return  this.restaurantList.stream().filter(restaurant -> restaurant.getRestaurantId().equals(id)).findFirst();
    }
    public Restaurant updateRetaurant(Restaurant restaurantToBeUpdated){
        Optional<Restaurant> restaurantOptional = this.restaurantList.stream().filter(restaurant -> restaurant.getRestaurantId().equals(restaurantToBeUpdated.getRestaurantId()))
                .findFirst()
                .map(restaurant -> {
                    restaurant.setRestaurantName(restaurantToBeUpdated.getRestaurantName())
                            .setAddress(restaurantToBeUpdated.getAddress())
                            .setMenu(restaurantToBeUpdated.getMenu());
                    return restaurant;
                });
        return restaurantOptional.orElse(null);
    }


    public void deleteRestaurant(Restaurant restaurant){
          this.restaurantList.remove(restaurant);
    }

}
