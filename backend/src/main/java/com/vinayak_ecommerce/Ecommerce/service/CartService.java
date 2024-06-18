package com.vinayak_ecommerce.Ecommerce.service;

import com.vinayak_ecommerce.Ecommerce.model.Cart;
import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.model.User;
import com.vinayak_ecommerce.Ecommerce.repository.CartRepo;
import com.vinayak_ecommerce.Ecommerce.repository.ComputerRepo;
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

    @Autowired
    private ComputerRepo computerRepo;


    public Cart getCart() {
        User user = userService.getCurrentUser();
        return cartRepo.findByUserId(user.getId());
    }

    public Optional<Cart> getCart(String id) {
        return cartRepo.findById(Long.valueOf(id));
    }

    public Cart addComputer(Long computerId) {
        Cart cart = userService.getCurrentUser().getCart();
        Optional<Computer> computer = computerRepo.findById(computerId);
        if (computer.isEmpty()) {
            throw new RuntimeException("Computer does not exist");
        }
        cart.getComputers().add(computer.get());
        return cartRepo.save(cart);
    }

    public Cart addComputerToCartId(String id, Long computerId) {
        Optional<Cart> cart = cartRepo.findById(Long.valueOf(id));
        if (cart.isEmpty()) {
            throw new RuntimeException("Cart doesnt exist");
        }

        Optional<Computer> computer = computerRepo.findById(computerId);
        if (computer.isEmpty()) {
            throw new RuntimeException("Computer does not exist");
        }
        cart.get().getComputers().add(computer.get());
        return cartRepo.save(cart.get());
    }

    public Cart updateCart(Cart cart) {
        return cartRepo.save(cart);
    }

    public Cart clearCart() {
        Cart cart = userService.getCurrentUser().getCart();
        cart.getComputers().clear();
        return cartRepo.save(cart);
    }

    public Cart clearCart(String id) {
        Optional<Cart> cart = cartRepo.findById(Long.valueOf(id));
        if (cart.isEmpty()) {
            throw new RuntimeException("Cart doesnt exist");
        }

        cart.get().getComputers().clear();
        return cartRepo.save(cart.get());
    }
}
