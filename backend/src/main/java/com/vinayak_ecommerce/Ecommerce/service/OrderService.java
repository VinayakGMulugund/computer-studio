package com.vinayak_ecommerce.Ecommerce.service;

import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.model.Order;
import com.vinayak_ecommerce.Ecommerce.model.User;
import com.vinayak_ecommerce.Ecommerce.repository.ComputerRepo;
import com.vinayak_ecommerce.Ecommerce.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ComputerRepo computerRepo;

    public List<Order> getAllOrders() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new RuntimeException("User not logged in");
        }
        long userId = currentUser.getId();
        return orderRepo.findAllByUserId(userId);
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepo.findById(Long.valueOf(id));
    }

    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order addComputerToOrder(String id, Long computerId) {
        Optional<Computer> computer = computerRepo.findById(computerId);
        if (computer.isEmpty()) {
            throw new RuntimeException("Computer does not exist");
        }

        Optional<Order> order = orderRepo.findById(Long.valueOf(id));
        if (order.isEmpty()) {
            throw new RuntimeException("Order does not exist");
        }

        Order orderToSave = order.get();
        orderToSave.getComputerList().add(computer.get());
        return orderRepo.save(orderToSave);
    }

    public void deleteComputerFromOrder(String id, Long computerId) {
        Optional<Computer> computer = computerRepo.findById(computerId);
        if (computer.isEmpty()) {
            throw new RuntimeException("Computer does not exist");
        }

        Optional<Order> existingOrder = orderRepo.findById(Long.valueOf(id));
        if (existingOrder.isEmpty()) {
            throw new RuntimeException("Order does not exist");
        }
        Order order = existingOrder.get();
        order.getComputerList().remove(computer.get());
    }

    public void deleteOrder(String id) {
        orderRepo.deleteById(Long.valueOf(id));
    }
}
