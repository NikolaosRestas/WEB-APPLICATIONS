package com.example.demo3.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="company_name")
    private String CompanyName;
    @Column(name="company_address")
    private String CompanyAddress;
    @Column(name="number")
    private String Number;
    @Column(name="afm")
    private String CompanyAfm;
    @Column(name="owner_name")
    private String OwnerName;
}
