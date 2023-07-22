package com.example.demo3.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="customer_afm")
    private String CustomerAfm;
    @Column(name="customer_name")
    private String CustomerName;
    @Column(name="gender")
    private String Gender;
    @Column(name="number")
    private String Number;
    @Column(name="customer_address")
    private String CustomerAddress;
    /*@Column(name="company_key")*/
    /*private long CompanyKey;*/
    @ManyToOne
    @JoinColumn(name="company_key")
    private Company company;
}
