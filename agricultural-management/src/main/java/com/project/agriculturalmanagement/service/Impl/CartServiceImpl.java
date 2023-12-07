package com.project.agriculturalmanagement.service.Impl;

import com.project.agriculturalmanagement.entity.Cart;
import com.project.agriculturalmanagement.entity.CartItem;
import com.project.agriculturalmanagement.entity.Customer;
import com.project.agriculturalmanagement.entity.Product;
import com.project.agriculturalmanagement.repository.CartItemRepository;
import com.project.agriculturalmanagement.repository.CartRepository;
import com.project.agriculturalmanagement.repository.ProductRepository;
import com.project.agriculturalmanagement.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart getCart(Customer customer) {
        return cartRepository.findByCustomerId(customer.getId());
    }

    @Override
    public Set<CartItem> getCartItems(long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    @Override
    public Cart addItem(int quantity, long productId, Customer customer) {
        Cart cart = cartRepository.findByCustomerId(customer.getId());
        Product product = productRepository.getReferenceById(productId);
        if(quantity>product.getQuantity()){
            return null;
        }
        if (cart ==null){
            cart = new Cart();
            cartRepository.save(cart);
        }
        CartItem item = cartItemRepository.findByCartIdAndProductId(cart.getId(),productId);
        Set<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
        if(cartItems == null ){
            cartItems = new HashSet<>();
            item = new CartItem();
            item.setQuantity(quantity);
            item.setTotalPrice(quantity * product.getPrice());
            item.setCart(cart);
            item.setProduct(product);
        } else {
            if(!cartItems.contains(item)){
                item = new CartItem();
                item.setQuantity(quantity);
                item.setTotalPrice(quantity * product.getPrice());
                item.setCart(cart);
                item.setProduct(product);
            } if(cartItems.contains(item)) {
                System.out.println(item);
                item.setTotalPrice((quantity + item.getQuantity()) * product.getPrice());
                item.setQuantity(item.getQuantity() + quantity);
                item.setCart(cart);
            }
        }
        cartItemRepository.save(item);
        cartItems = cartItemRepository.findByCartId(cart.getId());
        cart.setTotalItems(totalQuantity(cartItems));
        cart.setTotalPrice(totalPrice(cartItems));
        cart.setCustomer(customer);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateQuantity(int quantity, long id, Customer customer) {
        CartItem item = cartItemRepository.getReferenceById(id);
        Product product = item.getProduct();
        if(quantity>product.getQuantity()){
            return null;
        }
        item.setQuantity(quantity);
        item.setTotalPrice(quantity * product.getPrice());
        cartItemRepository.save(item);
        Cart cart = cartRepository.findByCustomerId(customer.getId());
        Set<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
        cart.setTotalItems(totalQuantity(cartItems));
        cart.setTotalPrice(totalPrice(cartItems));
        return cartRepository.save(cart);
    }

    @Override
    public void deleteItem(long id, Customer customer) {
        Cart cart = cartRepository.findByCustomerId(customer.getId());
        cartItemRepository.deleteById(id);
        Set<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
        cart.setTotalItems(totalQuantity(cartItems));
        cart.setTotalPrice(totalPrice(cartItems));
        cartRepository.save(cart);
    }


    public int totalQuantity(Set<CartItem>items){
        int totalQuantity=0;
        for(CartItem item: items){
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }
    public int totalPrice(Set<CartItem>items){
        int totalPrice=0;
        for(CartItem item: items){
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
