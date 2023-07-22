package com.example.demo3.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="vehicle_brand")
    private String VehicleBrand;
    @Column(name="vehicle_model")
    private String VehicleModel;
    @Column(name="plate")
    private String Plate;
    @Column(name="colour")
    private String Colour;
    @Column(name="cost")
    private String Cost;
    /*@Column(name="customer_key")*/
    @ManyToOne
    @JoinColumn(name="customer_key")
    private Customer customer;
}
