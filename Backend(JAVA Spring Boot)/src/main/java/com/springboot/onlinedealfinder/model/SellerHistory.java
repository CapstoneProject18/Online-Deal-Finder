package com.springboot.onlinedealfinder.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SellerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sellerId")

    private Seller seller;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")

    private Product product;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }


    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }


    public SellerHistory() {
    }

    public SellerHistory(Seller seller, Product product)
    {
        this.seller = seller;
        this.product = product;
    }
}
