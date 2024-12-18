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
    public Optional<CartProduct> removeProductFromCart(Long cartId) {
        Optional<CartProduct> cartId1 = cartRepo.findById(cartId);
        if(cartId1.isPresent()){
            CartProduct cartProduct1 = cartId1.get();
            cartRepo.deleteById(cartProduct1.getCartId());
        }
        return cartId1;
    }

    @Override
    public CartProduct updateProductQuantity(Long cartId, Long productId, Long quantity) {
        return null;
    }

    @Override
    public Optional<CartProduct> getCartForUser(Long userId, Product product) {
        Optional<CartProduct> byId = cartRepo.findById(userId);
        if(byId.isPresent()){
            CartProduct cartProduct = byId.get();
            String uri = "http://FULLFLEDGEDPRODUCTPART/products/getUserProducts/"+cartProduct.getUserId();
            Product[] product1 = restTemplate.getForObject(uri, Product[].class);
            List<Product> list = Arrays.asList(product1);
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
