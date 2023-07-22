package com.example.demo2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Nomos")
public class Nomos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(name="description")
    private String Description;
}