package com.vinayak_ecommerce.Ecommerce.controller;

import com.vinayak_ecommerce.Ecommerce.model.Order;
import com.vinayak_ecommerce.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("")
    public Order updateOrderById(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/{id}")
    public Order addComputerToOrder(@PathVariable String id, @RequestBody Map<String, Long> computerId) {
        return orderService.addComputerToOrder(id, computerId.get("computerId"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> deleteComputerFromOrder(@PathVariable String id, @RequestBody Map<String, Long> computerId) {
        orderService.deleteComputerFromOrder(id, computerId.get("computerId"));
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("deleted");
    }
 }
