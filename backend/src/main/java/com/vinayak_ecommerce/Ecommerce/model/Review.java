package com.vinayak_ecommerce.Ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;
}
