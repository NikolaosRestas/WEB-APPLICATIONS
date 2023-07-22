package com.example.demo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(name="name")
    private String Name;
    @Column(name="specialty")
    private String Specialty;
    @Column(name="phone")
    private String Phone;
    @Column(name="gender")
    private String Gender;

    @ManyToOne
    @JoinColumn(name="gym_key")
    private Gym gym;

}