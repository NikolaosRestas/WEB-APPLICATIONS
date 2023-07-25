package com.example.demo2.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "gym")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "nomos_key")
    private County county;

    public Gym(long id, String name, String address, County county) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.county = county;
    }


    public Gym() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public County getNomos() {
        return county;
    }

    public void setNomos(County county) {
        this.county = county;
    }
}
