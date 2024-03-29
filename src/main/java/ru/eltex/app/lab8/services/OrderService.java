package ru.eltex.app.lab8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab8.repositories.OrderRepository;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Orders<?> readAll(){
        return new Orders(orderRepository.findAll());
    }

    public Order readById(String order_id){
        return orderRepository.getOne(UUID.fromString(order_id));
    }

    public void delete(Order order){
        orderRepository.delete(order);
    }
}
