package com.example.demo4.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "county")
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;

    public County(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public County() {
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
}