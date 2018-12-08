package com.springboot.onlinedealfinder.model;

import javax.persistence.*;

@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long buyerId;

    private String name;

    private String email;

    private String pass;

    private String imgUrl;


    public Buyer() {
    }

    public Buyer(String name, String email, String pass, String imgUrl)
    {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.imgUrl = imgUrl;
    }

    public void setBuyerId(long sellerId)
    {
        this.buyerId = sellerId;
    }

    public long getBuyerId()
    {
        return buyerId;
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
}
