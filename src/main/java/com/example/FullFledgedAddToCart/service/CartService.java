package com.example.FullFledgedAddToCart.service;

import com.example.FullFledgedAddToCart.entities.CartProduct;
import com.example.FullFledgedAddToCart.entities.Product;

import java.util.Optional;

public interface CartService {


        CartProduct addProductToCart(CartProduct cartProduct);

        Optional<CartProduct> removeProductFromCart(Long cartId);

        CartProduct updateProductQuantity(Long cartId, Long productId, Long quantity);

        Optional<CartProduct> getCartForUser(Long userId , Product product);

        Long calculateCartTotal(Long cartId);

        CartProduct clearCart(Long cartId);

        CartProduct getCartDetails(Long cartId);
}
