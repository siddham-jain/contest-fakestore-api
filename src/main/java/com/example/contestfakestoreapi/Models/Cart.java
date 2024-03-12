package com.example.contestfakestoreapi.Models;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Cart {
    long id;
    long userId;
    Date date;
    List<Product> products;

    public Cart() {
    }

    public Cart(Long id, long userId, Date date, List<Product> product) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = product;
    }   

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
