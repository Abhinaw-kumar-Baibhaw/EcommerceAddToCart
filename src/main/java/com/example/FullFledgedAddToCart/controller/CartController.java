package com.example.FullFledgedAddToCart.controller;


import com.example.FullFledgedAddToCart.entities.CartProduct;
import com.example.FullFledgedAddToCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public CartProduct createCart(@RequestBody CartProduct cartProduct){
        return cartService.addProductToCart(cartProduct);
    }

    @GetMapping("/getCarts/{userId}")
    public Optional<CartProduct> getAll(@PathVariable Long userId){
        return cartService.getCartForUser(userId);
    }

}
