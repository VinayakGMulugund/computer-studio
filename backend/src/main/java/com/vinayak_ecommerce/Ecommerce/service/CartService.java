package com.vinayak_ecommerce.Ecommerce.service;

import com.vinayak_ecommerce.Ecommerce.model.Cart;
import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.repository.CartRepo;
import com.vinayak_ecommerce.Ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepo cartRepo;


    public List<Computer> getUserComputers() {
//        long userId = userService.getCurrentUser().getId();
        long userId = 1;
        Cart cart = cartRepo.findByUserId(userId);
        return cart.getComputers();
    }

    public Cart getCart() {
//        long userId = userService.getCurrentUser().getId();
        return cartRepo.findByUserId(1);
    }

}
