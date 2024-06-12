package com.vinayak_ecommerce.Ecommerce.model;

import com.vinayak_ecommerce.Ecommerce.model.utils.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    private double price;
    private String imageUrl;
}
