package com.vinayak_ecommerce.Ecommerce.controller;

import com.vinayak_ecommerce.Ecommerce.model.Cart;
import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("")
    public Cart getCart() {
        return cartService.getCart();
    }

    @GetMapping("/{id}")
    public Optional<Cart> getCartById(@PathVariable String id) {
        return cartService.getCart(id);
    }

    @PostMapping("")
    public Cart addComputerToCart(@RequestBody Map<String, Long> computer) {
        return cartService.addComputer(computer.get("computerId"));
    }

    @PostMapping("/{id}")
    public Cart addComputerToCartId(@PathVariable String id, @RequestBody Map<String, Long> computer) {
        return cartService.addComputerToCartId(id, computer.get("computerId"));
    }

    @PutMapping("")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("")
    public Cart clearCart() {
        return cartService.clearCart();
    }

    @DeleteMapping("/{id}")
    public Cart clearCartById(@PathVariable String id) {
        return cartService.clearCart(id);
    }
}
