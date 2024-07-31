package com.java.foodiecli.repository;

import com.java.foodiecli.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRespository {
    private List<Order> orderList;

    public OrderRespository() {
        this.orderList = new ArrayList<>();
    }
    public Order save(Order order){
        this.orderList.add(order);
        return order;
    }
    public List<Order> getOrdersList(){
        return this.orderList;
    }
    public Optional<Order> findOrderById(String id){
        return this.orderList.stream().filter(order -> order.getOrderId().equals(id)).findFirst();
    }
}
