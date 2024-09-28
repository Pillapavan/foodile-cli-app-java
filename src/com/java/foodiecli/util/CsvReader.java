package com.java.foodiecli.util;

import com.java.foodiecli.model.Customer;
import com.java.foodiecli.model.Dish;
import com.java.foodiecli.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    /*
    Read customer details from the csv files
     */
    public List<Customer> readCustomerFromCsv(){
        List<Customer> customersList=new ArrayList<>();
        String CUSTOMER_FILE_PATH = "C:\\Users\\NagaTatajiSunkara\\OneDrive\\Desktop\\java\\foodile-cli-app-java\\data\\customers.csv";
          //java IO  classes (FileReader,BufferReader)
        //try with resource
        String line;
        String splitCsvBy=",";
        try(BufferedReader br=new BufferedReader(new FileReader(CUSTOMER_FILE_PATH))){
            br.readLine();
            while((line= br.readLine()) != null){
                String[] data = line.split(splitCsvBy);
                Customer customer =new Customer();
                customer.setCustomerId(data[0])
                          .setCustomerName(data[1])
                          .setEmail(data[2])
                          .setPassword(data[3]);
                customersList.add(customer);
            }
        }
        catch (IOException e){
            e.getStackTrace();
            System.out.println("Issues in reading csv file from the path"+CUSTOMER_FILE_PATH);
            System.exit(0);
        }
        return customersList;
    }

    //read Dishes from csv files

    public List<Dish> readDishesFromCsv(){

        List<Dish> dishList= new ArrayList<>();
        String DISH_FILE_PATH="C:\\Users\\NagaTatajiSunkara\\OneDrive\\Desktop\\java\\foodile-cli-app-java\\data\\dishes.csv";
        String line;
        String splitCsvBy=",";
        try(BufferedReader br=new BufferedReader(new FileReader(DISH_FILE_PATH))){
           br.readLine();
           while ((line = br.readLine()) != null){
               String[] data = line.split(splitCsvBy);
               Dish dish=new Dish();
               dish.setDishId(data[0])
                      .setDishName(data[1])
                    .setDescription(data[2])
                .setPrice(Double.parseDouble(data[3]));
               dishList.add(dish);
           }


        }catch(IOException e){
            System.out.println("Issues in reading csv file from the path"+DISH_FILE_PATH);
            System.exit(0);
        }
           return dishList;
        }

        //read Restaurants from csv files
        public List<Restaurant> readRestaurantsFromCsv(){

            List<Restaurant> restaurantList= new ArrayList<>();
            String RESTAURANTS_FILE_PATH="C:\\Users\\NagaTatajiSunkara\\OneDrive\\Desktop\\java\\foodile-cli-app-java\\data\\restaurants.csv";
            String line;
            String splitCsvBy=",";
            try(BufferedReader br=new BufferedReader(new FileReader(RESTAURANTS_FILE_PATH))){
                br.readLine();
                while ((line = br.readLine()) != null){
                    String[] data = line.split(splitCsvBy);
                    Restaurant restaurant = new Restaurant();
                    restaurant.setRestaurantId(data[0])
                               .setRestaurantName(data[1])
                               .setAddress(data[2])
                               .setMenu(Arrays.asList((data[3]).split(":")));
                    restaurantList.add(restaurant);
                }


            }catch(IOException e){
                System.out.println("Issues in reading csv file from the path" + RESTAURANTS_FILE_PATH);
                System.exit(0);
            }
            return restaurantList;
        }

        

}
