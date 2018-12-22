package com.springboot.onlinedealfinder.controller;

import com.springboot.onlinedealfinder.Service.AmazonClient;
import com.springboot.onlinedealfinder.model.Buyer;
import com.springboot.onlinedealfinder.model.Seller;
import com.springboot.onlinedealfinder.repository.BuyerRepository;
import com.springboot.onlinedealfinder.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping(value = "/users")

public class UserController {
    @Autowired(required = true)
    private BuyerRepository buyerRepository;
    @Autowired(required = true)
    private SellerRepository sellerRepository;

    @Autowired
    private AmazonClient amazonClient;

    @GetMapping(value="/allBuyers")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Buyer> getAllUsers()
    {
        return buyerRepository.findAll();
    }

    @GetMapping(value = "/loginBuyer/{email}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Buyer getUserByEmail(@PathVariable String email)
    {
        return buyerRepository.findByEmail(email);
    }

    @PostMapping(value = "/createBuyer")
    @CrossOrigin(origins = "http://localhost:4200")
    public Buyer createBuyer(String name, String email, String pass, MultipartFile image)
    {
        String imgUrl =  this.amazonClient.uploadFileTos3bucket(image);
        return buyerRepository.save(new Buyer(name, email, pass, imgUrl));
    }

    @GetMapping(value="/allSellers")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Seller> getAllSeller()
    {
        return sellerRepository.findAll();
    }

}
