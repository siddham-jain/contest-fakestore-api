package com.example.contestfakestoreapi.dtos;

import java.sql.Date;
import java.util.List;

import com.example.contestfakestoreapi.Models.Product;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CartFetchDTO {
    long id;
    long userId;
    Date date;
    List<Product> products;

    public CartFetchDTO() {
    }

    public CartFetchDTO(Long id, long userId, Date date, List<Product> product) {
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