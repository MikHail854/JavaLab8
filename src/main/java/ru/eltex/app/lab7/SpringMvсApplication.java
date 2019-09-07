package ru.eltex.app.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.eltex.app.lab1.Phone;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab1.Smartphone;
import ru.eltex.app.lab1.TheTablet;
import ru.eltex.app.lab2.Credentials;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab2.ShoppingCart;

/**
 * view
 */

@SpringBootApplication
@EntityScan("ru.eltex.app")
@ComponentScan("ru.eltex.app")
@EnableJpaRepositories("ru.eltex.app.lab8.repositories")
public class SpringMvсApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvсApplication.class, args);
    }
//        ApplicationContext context = SpringApplication.run(SpringMvсApplication.class, args);
//        ShoppingCart<Products> cart1 = (ShoppingCart<Products>) context.getBean("Cart1");//создание корзины 1
//        ShoppingCart<Products> cart2 = (ShoppingCart<Products>) context.getBean("Cart2");//создание корзины 2
//
//        cart1.add(new Phone("Nokia", 5, "2017 года", 440, "Китай", "Android", "классический"));
//        cart1.add(new Smartphone("Xiaomi", 4, "2019 года", 652, "Китай", "Android", "micro-SIM", "2"));
//        cart1.add(new TheTablet("Apple", 2, "2018 года", 770, "США", "IOS", "Qualcomm", "720*1280"));
//
//        cart2.add(new Phone("Philips", 7, "2017 года", 9440, "Чехия", "Android", "раскладушка"));
//        cart2.add(new Smartphone("Honor", 4, "2019 года", 153, "Япония", "Android", "micro-SIM", "2"));
//        cart2.add(new TheTablet("Meizu", 2, "2018 года", 938, "США", "IOS", "Qualcomm", "2560*1440"));
//
//        Orders<?> orders = (Orders) context.getBean("Orders");
//
//        orders.purchase(cart1, (Credentials) context.getBean("Credentials"));
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        orders.purchase(cart2, (Credentials) context.getBean("Credentials"));
//    }
}
