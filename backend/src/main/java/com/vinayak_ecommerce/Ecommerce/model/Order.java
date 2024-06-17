package com.vinayak_ecommerce.Ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    private String status;
    private Date date;
}
