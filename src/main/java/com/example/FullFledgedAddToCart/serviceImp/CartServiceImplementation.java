package com.example.FullFledgedAddToCart.serviceImp;

import com.example.FullFledgedAddToCart.entities.CartProduct;
import com.example.FullFledgedAddToCart.entities.Product;
import com.example.FullFledgedAddToCart.repo.CartRepo;
import com.example.FullFledgedAddToCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CartProduct addProductToCart(CartProduct cartProduct) {
        return cartRepo.save(cartProduct);
    }

    @Override
    public CartProduct removeProductFromCart(Long cartId, Long productId) {
        return null;
    }

    @Override
    public CartProduct updateProductQuantity(Long cartId, Long productId, Long quantity) {
        return null;
    }

    @Override
    public Optional<CartProduct> getCartForUser(Long userId) {
        Optional<CartProduct> byId = cartRepo.findById(userId);
        if(byId.isPresent()){
            CartProduct cartProduct = byId.get();
            String uri = "http://FULLFLEDGEDPRODUCTPART/products/getUserProducts/"+userId;
            Product[] product = restTemplate.getForObject(uri, Product[].class);
            List<Product> list = Arrays.asList(product);
            cartProduct.setProductList(list);
            return Optional.of(cartProduct);
        }
        return byId;
    }

    @Override
    public Long calculateCartTotal(Long cartId) {
        return 0L;
    }

    @Override
    public CartProduct clearCart(Long cartId) {
        return null;
    }

    @Override
    public CartProduct getCartDetails(Long cartId) {
        return null;
    }
}
