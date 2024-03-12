package com.example.contestfakestoreapi.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.contestfakestoreapi.Models.Cart;

@Service
public interface CartService {
    public List<Cart> getAllCarts();
    public Cart getSingleCart(long id);
    public Cart addCart(Cart cart);
    public Cart updateCart(Cart cart);
    public void deleteCart(long id);
    public Cart getUserCart(long userId);
    public List<Cart> getInDateRange(String startDate, String endDate);
}
