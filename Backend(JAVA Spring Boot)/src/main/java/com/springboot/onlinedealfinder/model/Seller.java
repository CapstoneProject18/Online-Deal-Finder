package com.springboot.onlinedealfinder.model;

import javax.persistence.*;

@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sellerId")
    private long sellerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private String pass;

    @Column(name = "img_url")
    private String imgUrl;


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
}
