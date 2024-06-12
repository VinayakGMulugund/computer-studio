package com.vinayak_ecommerce.Ecommerce.repository;

import com.vinayak_ecommerce.Ecommerce.model.Cart;
import com.vinayak_ecommerce.Ecommerce.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {
    Cart findByUserId(long userId);
}
