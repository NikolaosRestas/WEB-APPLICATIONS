package com.example.demo4.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
    /*private Customer customer;*/


    public Program(long id, String duration, BigDecimal price, List customers) {
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.customers= customers;
    }

    public Program() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public List<Customer> getCustomers(){
        return customers;
    }

    public void setCustomers(List customers){
        this.customers = customers;
    }


}
