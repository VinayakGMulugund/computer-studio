package com.vinayak_ecommerce.Ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "motherboard_id")
    private Product motherboard;

    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private Product cpu;

    @ManyToOne
    @JoinColumn(name = "gpu_id")
    private Product gpu;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Product storage;

    @ManyToOne
    @JoinColumn(name = "ram_id")
    private Product ram;

    @ManyToOne
    @JoinColumn(name = "psu_id")
    private Product psu;

    @ManyToOne
    @JoinColumn(name = "body_id")
    private Product body;
}
