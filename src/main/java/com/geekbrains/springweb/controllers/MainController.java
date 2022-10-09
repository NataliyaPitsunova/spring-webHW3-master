package com.geekbrains.springweb.controllers;

import com.geekbrains.springweb.data.Product;
import com.geekbrains.springweb.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private ProductRepository groceryList;

    public MainController(ProductRepository groceryList) {
        this.groceryList = groceryList;
    }

    @GetMapping("/products/{id}")
    public String showProduct(Model model, @PathVariable Long id) {
        Product product = groceryList.findIdProduct(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
       model.addAttribute("groceryList", groceryList.getAllProduct());
        return "products_page";
    }

     @GetMapping("/show_form")
    public String show(){
        return "simple_form";
     }

    @GetMapping("/product_add")
    public String productAdd(@RequestParam Long id, @RequestParam(defaultValue = "") String title, @RequestParam Long cost){
       Product product = new Product(id,title,cost);
       groceryList.add(product);
        return "redirect:/products";
    }


}
