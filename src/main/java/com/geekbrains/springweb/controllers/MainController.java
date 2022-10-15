package com.geekbrains.springweb.controllers;

import com.geekbrains.springweb.data.Product;
import com.geekbrains.springweb.repositories.ProductRepository;
import com.geekbrains.springweb.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showProductsPage() {
        return productService.getAllProducts();
    }

    @GetMapping("products/addProduct")
    public void productAdd( @RequestParam Long id,  @RequestParam String title, @RequestParam Long cost) {
        Product product = new Product(id, title, cost);
        productService.add(product);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.delete(id);

    }


}

    /*
    @GetMapping("/products/{id}")
    public String showProduct(Model model, @PathVariable Long id) {
        Product product = groceryList.findIdProduct(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }*/
/*
    @GetMapping("/products")
    public String showProductsPage(Model model) {
       model.addAttribute("groceryList", groceryList.getAllProduct());
        return "products_page";
    }*/
/*
     @GetMapping("/show_form")
    public String show(){
        return "simple_form";
     }*/
/*
    @GetMapping("/product_add")
    public String productAdd(@RequestParam Long id, @RequestParam(defaultValue = "") String title, @RequestParam Long cost){
       Product product = new Product(id,title,cost);
       groceryList.add(product);
        return "redirect:/products";
    }*/


