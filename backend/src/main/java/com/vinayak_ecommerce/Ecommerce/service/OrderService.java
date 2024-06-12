package com.vinayak_ecommerce.Ecommerce.service;

import com.vinayak_ecommerce.Ecommerce.model.Order;
import com.vinayak_ecommerce.Ecommerce.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
