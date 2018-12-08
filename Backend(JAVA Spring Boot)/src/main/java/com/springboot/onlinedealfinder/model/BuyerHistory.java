package com.springboot.onlinedealfinder.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "buyer_history")
public class BuyerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")

    private Buyer buyer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")

    private Product product;

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }


    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }


    public BuyerHistory() {
    }

    public BuyerHistory(Buyer buyer, Product product)
    {
        this.buyer = buyer;
        this.product = product;
    }
}
