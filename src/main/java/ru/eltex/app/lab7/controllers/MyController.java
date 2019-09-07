package ru.eltex.app.lab7.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.lab1.Phone;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab2.ShoppingCart;
import ru.eltex.app.lab5.ManagerOrderJSON;
import ru.eltex.app.lab5.OrderDeserializer;
import ru.eltex.app.lab5.OrdersDeserializer;
import ru.eltex.app.lab5.ProductDeserializer;
import ru.eltex.app.lab8.repositories.OrderRepository;
import ru.eltex.app.lab8.services.OrderService;
import ru.eltex.app.lab8.services.ProductsService;


@RestController
public class MyController {
    private static final Logger logger = Logger.getLogger(MyController.class);
    private final Gson gson = new GsonBuilder().registerTypeAdapter(Order.class, new OrderDeserializer())
            .registerTypeAdapter(Orders.class, new OrdersDeserializer())
            .registerTypeAdapter(Products.class, new ProductDeserializer()).setPrettyPrinting().create();

    /*private Orders<?> orders;

    @Autowired
    public MyController(Orders<?> orders) {
        this.orders = orders;
    }*/

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductsService productsService;

    @GetMapping(params = "command=readall")
    public Object readall() {
        logger.info("readall");
      //  return orderService.readAll();
        return gson.toJson(orderService.readAll());
    }

    @GetMapping(params = "command=readById")
    public String readById(String order_id) {
        logger.info("readById");
        return gson.toJson(orderService.readById(order_id));
    }

    @GetMapping(params = "command=addToCard")
    public String addToCard(String card_id) {
        logger.info("addToCard");
        Products phone = new Phone();
        productsService.addToCard(phone);
        return phone.getId().toString();
    }

    @GetMapping(params = "command=delById")
    public String delById(String order_id) {
        logger.info("delById");
        Order order = orderService.readById(order_id);
        if (order == null) {
            throw new NullPointerException();
        }
        orderService.delete(order);
        return "0";
    }
}
