package com.example.demo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(name="customer_name")
    private String CustomerName;
    @Column(name="customer_address")
    private String CustomerAddress;
    @Column(name="email")
    private String Email;
    @ManyToOne
    @JoinColumn(name="gym_key")
    /*private long GymKey;*/
    private Gym gym;
}