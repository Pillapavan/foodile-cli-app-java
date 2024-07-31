package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.OrderAlreadyExistsException;
import com.java.foodiecli.exceptions.OrderNotFoundException;
import com.java.foodiecli.model.Order;
import com.java.foodiecli.repository.OrderRespository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    private final OrderRespository orderRespository;

    public OrderServiceImpl(OrderRespository orderRespository) {
        this.orderRespository = orderRespository;
    }

    @Override
    public Order save(Order order) {
        return this.orderRespository.save(order);
    }

    @Override
    public List<Order> getOrdersList() {
        return this.orderRespository.getOrdersList();
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRespository.findOrderById(id);
        if (orderById.isEmpty()){
            throw new OrderNotFoundException("Order is Not Found with this Id"+id);
        }
        return orderById.get();
    }
}
