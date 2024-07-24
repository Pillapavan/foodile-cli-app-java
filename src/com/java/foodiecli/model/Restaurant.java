package com.java.foodiecli.model;

import java.util.List;
import java.util.Objects;

public class Restaurant {
    // String id, String name, String address,List<Dish> menu
    private String id;
    private String name;
    private String address;
    private List<String> menu;

    public Restaurant(){

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, menu);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                '}';
    }
}
