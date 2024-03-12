package com.example.contestfakestoreapi.Services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.contestfakestoreapi.Models.Cart;
import com.example.contestfakestoreapi.dtos.CartFetchDTO;


@Service
public class CartServiceImplementation implements CartService{

    private final String url = "https://fakestoreapi.com/carts";
    private final RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("null")
    @Override
    public List<Cart> getAllCarts() {
        List<CartFetchDTO> carts = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CartFetchDTO>>() {}).getBody();

        assert carts != null;

        return carts.stream().map(this::mapToCart).toList();
    }


    private Cart mapToCart(CartFetchDTO cart){
        Cart newCart = new Cart();
        newCart.setId(cart.getId());
        newCart.setUserId(cart.getUserId());
        newCart.setProducts(cart.getProducts());

        return newCart;
    }

    @Override
    public Cart getSingleCart(long id){
        CartFetchDTO cart = restTemplate.getForObject(url + "/" + id, CartFetchDTO.class);

        assert cart != null;

        return mapToCart(cart);
    }

    @Override
    public Cart addCart(Cart cart){
        Cart newCart = new Cart();
        newCart.setId(cart.getId());
        newCart.setUserId(cart.getUserId());
        newCart.setProducts(cart.getProducts());
        newCart.setDate(cart.getDate());

        Cart response = restTemplate.postForObject(url, newCart, Cart.class);

        assert response != null;

        return response;
    }

    @Override
    public Cart updateCart(Cart cart){
        CartFetchDTO newCart = new CartFetchDTO();
        newCart.setId(cart.getId());
        newCart.setUserId(cart.getUserId());
        newCart.setProducts(cart.getProducts());
        newCart.setDate(cart.getDate());

        restTemplate.put(url + "/" + cart.getId(), newCart);

        return cart;
    }

    @Override
    public void deleteCart(long id){
        restTemplate.delete(url + "/" + id);
    }

    public Cart getUserCart(long userId){
        CartFetchDTO cart = restTemplate.getForObject(url + "/user/" + userId, CartFetchDTO.class);

        assert cart != null;

        return mapToCart(cart);
    }

    @SuppressWarnings("null")
    @Override
    public List<Cart> getInDateRange(String startDate, String endDate){
        List<CartFetchDTO> carts = restTemplate.exchange(
                url + "?startDate=" + startDate + "&endDate=" + endDate,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CartFetchDTO>>() {}).getBody();

        assert carts != null;

        return carts.stream().map(this::mapToCart).toList();
    }
}
