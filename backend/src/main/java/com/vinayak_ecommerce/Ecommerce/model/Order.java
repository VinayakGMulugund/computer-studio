package com.vinayak_ecommerce.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long totalPrice;

    @ManyToMany
    @JoinTable(
            name = "order_computer",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id")
    )
    private List<Computer> computerList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status;
    private Date date;
}
