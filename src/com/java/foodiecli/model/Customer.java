package com.java.foodiecli.model;

import java.util.Objects;

 public class Customer {
    //String id, c,String name , String email, String password
    private String id;
    private String name;
    private String email;
    private String password;

     public Customer() {
     }

     public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCustomerId() {
        return id;
    }

    public Customer setCustomerId(String id) {
        this.id = id;
        return  this;
    }

    public String getCustomerName() {
        return name;
    }

    public Customer setCustomerName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
