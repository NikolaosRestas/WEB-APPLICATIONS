package com.example.demo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Gym")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(name="gym_name")
    private String GymName;
    @Column(name="gym_address")
    private String GymAddress;
    @ManyToOne
    @JoinColumn(name="nomos_key")
    private Nomos nomos;
    /*private Nomos nomos_key;*/
    /*private long NomosKey;*/
}
