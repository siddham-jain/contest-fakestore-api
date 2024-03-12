package com.example.contestfakestoreapi.Controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.contestfakestoreapi.Models.Cart;
import com.example.contestfakestoreapi.Services.CartService;


@RestController
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/cart/{id}")
    public Cart getSingleCart(@PathVariable long id) {
        return cartService.getSingleCart(id);
    }

    @PostMapping("/cart/add")
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @PutMapping("/cart/update")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/cart/delete/{id}")
    public void deleteCart(@PathVariable long id) {
        cartService.deleteCart(id);
    }

    @GetMapping("/cart/user/{userId}")
    public Cart getUserCart(@PathVariable long userId) {
        return cartService.getUserCart(userId);
    }

    @GetMapping("cart/startDate/{startDate}/endDate/{endDate}")
    public List<Cart> getInDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return cartService.getInDateRange(startDate, endDate);
    }    
}
