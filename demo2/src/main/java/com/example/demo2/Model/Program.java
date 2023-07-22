package com.example.demo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(name="kind")
    private String Kind;
    @Column(name="duration")
    private String Duration;
    @Column(name="price")
    private String Price;
    @ManyToOne
    @JoinColumn(name="customer_key")
    private Customer customer;
}
