package com.java.foodiecli.repository;

import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class RestaurantRepository {
    private final List<Restaurant> restaurantList;

    public RestaurantRepository() {
        this.restaurantList= Factory.getCsvReader().readRestaurantsFromCsv();

    }
    public List<Restaurant> getAllRestaurants(){
         return this.restaurantList;
    }
    public Restaurant saveRestaurant(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        return restaurant;
    }
    public Optional<Restaurant> getRestaurantById(String id) {
      return  this.restaurantList.stream().filter(restaurant -> restaurant.getRestaurantId().equals(id)).findFirst();
    }
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated){
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
