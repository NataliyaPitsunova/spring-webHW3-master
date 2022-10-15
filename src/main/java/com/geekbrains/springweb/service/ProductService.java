package com.geekbrains.springweb.service;

import com.geekbrains.springweb.data.Product;
import com.geekbrains.springweb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public ProductRepository groceryList;

    public ProductService(ProductRepository groceryList) {
        this.groceryList = groceryList;
    }
    public List<Product> getAllProducts(){
        return  groceryList.getAllProducts();
    }

    public void add(Product product) {
        groceryList.add(product);
    }

    public void delete(Long id) {
        groceryList.deleteById(id);
    }
}
