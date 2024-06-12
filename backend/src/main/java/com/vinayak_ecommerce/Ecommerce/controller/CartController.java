package com.vinayak_ecommerce.Ecommerce.controller;

import com.vinayak_ecommerce.Ecommerce.model.Cart;
import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.model.User;
import com.vinayak_ecommerce.Ecommerce.service.CartService;
import com.vinayak_ecommerce.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping("")
    public List<Computer> getComputers() {
        return cartService.getUserComputers();
    }

    @GetMapping("/1")
    public Cart getCart() {
        return cartService.getCart();
    }

}
