package com.vinayak_ecommerce.Ecommerce.controller;

import com.vinayak_ecommerce.Ecommerce.model.Order;
import com.vinayak_ecommerce.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
