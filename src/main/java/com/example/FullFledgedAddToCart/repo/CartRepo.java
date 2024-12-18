package com.example.FullFledgedAddToCart.repo;

import com.example.FullFledgedAddToCart.entities.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<CartProduct,Long> {
}
