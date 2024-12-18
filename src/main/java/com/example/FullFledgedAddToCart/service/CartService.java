package com.example.FullFledgedAddToCart.service;

import com.example.FullFledgedAddToCart.entities.CartProduct;

import java.util.Optional;

public interface CartService {


        CartProduct addProductToCart(CartProduct cartProduct);

        CartProduct removeProductFromCart(Long cartId, Long productId);

        CartProduct updateProductQuantity(Long cartId, Long productId, Long quantity);

        Optional<CartProduct> getCartForUser(Long userId);

        Long calculateCartTotal(Long cartId);

        CartProduct clearCart(Long cartId);

        CartProduct getCartDetails(Long cartId);
}
