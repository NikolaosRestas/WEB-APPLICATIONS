package com.example.demo2.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "kind")
    private String kind;

    @Column(name = "duration")
    private String duration;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinColumn(name = "customer_key")
    private List<Customer> customers;

}
