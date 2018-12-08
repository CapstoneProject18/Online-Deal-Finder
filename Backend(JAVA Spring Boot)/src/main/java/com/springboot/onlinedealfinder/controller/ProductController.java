package com.springboot.onlinedealfinder.controller;


import com.springboot.onlinedealfinder.model.Buyer;
import com.springboot.onlinedealfinder.model.Product;
import com.springboot.onlinedealfinder.model.Seller;
import com.springboot.onlinedealfinder.repository.BuyerRepository;
import com.springboot.onlinedealfinder.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired(required = true)
    private ProductRepository productRepository;

    @GetMapping(value="/allProducts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Product> getAllProducts()
    {
        return productRepository.findAll();
    }


    @GetMapping(value = "/{productName}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product getProductByProductName(@PathVariable String productName){
        return productRepository.findByProductName(productName);
    }

//
//    @PostMapping(value = "/create")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public Buyer createUser(@RequestBody Map<String, String> body)
//    {
//        String productName = body.get("productName");
//        String price = body.get("price");
//        String productImage = body.get("productImage");
//        String sellerId = body.get("sellerId");
//
//        return productRepository.save(new Product(productName, price, productImage, Seller));
//    }
}
