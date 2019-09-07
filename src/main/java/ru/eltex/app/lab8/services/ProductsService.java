package ru.eltex.app.lab8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltex.app.lab1.Products;
import ru.eltex.app.lab8.repositories.ProductsRepository;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public boolean addToCard(Products products){
        try {
            productsRepository.save(products);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
