package com.example.manytomany.Order;


import com.example.manytomany.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Optional<Order> findById(int orderId){
        return orderRepository.findById(orderId);
    }
    public Order save(Order order){
        orderRepository.save(order);
        return order;
    }
}
