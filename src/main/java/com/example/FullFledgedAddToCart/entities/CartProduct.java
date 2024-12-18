package com.example.FullFledgedAddToCart.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "Cart")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private Long userId;

    private Long quantity;

    private Long total;

    private Long productId;

    @Transient
    private List<Product> productList = new ArrayList<>();

    public CartProduct(){

    }

    public CartProduct(Long cartId, Long userId, Long quantity, Long total, Long productId, List<Product> productList) {
        this.cartId = cartId;
        this.userId = userId;
        this.quantity = quantity;
        this.total = total;
        this.productId = productId;
        this.productList = productList;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", productId=" + productId +
                ", productList=" + productList +
                '}';
    }
}
