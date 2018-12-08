package com.springboot.onlinedealfinder.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import com.springboot.onlinedealfinder.*;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sellerId;

    private String name;

    private String email;

    private String pass;

    private String imgUrl;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

    public Seller() {
    }

    public Seller(String name, String uname, String email, String pass, String imgUrl)
    {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.imgUrl = imgUrl;
    }

    public void setSellerId( long sellerId)
    {
        this.sellerId = sellerId;
    }

    public long getSellerId()
    {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass()
    {
        this.pass = pass;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setSeller(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setSeller(null);
    }
}
