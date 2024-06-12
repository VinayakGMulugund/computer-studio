package com.vinayak_ecommerce.Ecommerce.repository;

import com.vinayak_ecommerce.Ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
