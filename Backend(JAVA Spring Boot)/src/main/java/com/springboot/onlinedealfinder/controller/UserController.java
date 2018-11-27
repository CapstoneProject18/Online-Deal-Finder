package com.springboot.onlinedealfinder.controller;

import com.springboot.onlinedealfinder.model.Buyer;
import com.springboot.onlinedealfinder.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")

public class UserController {
    @Autowired(required = true)
    private BuyerRepository buyerRepository;

    @GetMapping(value="/allBuyers")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Buyer> getAllUsers()
    {
        return buyerRepository.findAll();
    }

    @GetMapping(value = "/login/{email}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Buyer getUserByEmail(@PathVariable String email)
    {
        return buyerRepository.findByEmail(email);
    }

    @PostMapping(value = "/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public Buyer createUser(@RequestBody Map<String, String> body)
    {
        String name = body.get("name");
        String email = body.get("email");
        String pass  = body.get("pass");
        String imgUrl = body.get("imgUrl");

        return buyerRepository.save(new Buyer(name, email, pass, imgUrl));
    }


}
