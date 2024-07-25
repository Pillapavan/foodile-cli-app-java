package com.java.foodiecli.model;

import java.util.Objects;

public class Dish {
    //String id, String name, String description, double price
    private String id;
    private String name;
    private String description;
    private double price;

    public Dish(){

    }

    public String getDescription() {
        return description;
    }

    public Dish setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDishId() {
        return id;
    }

    public Dish setDishId(String id) {
        this.id = id;
        return this;
    }

    public String getDishName() {
        return name;
    }

    public Dish setDishName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Dish setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(price, dish.price) == 0 && Objects.equals(id, dish.id) && Objects.equals(name, dish.name) && Objects.equals(description, dish.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
