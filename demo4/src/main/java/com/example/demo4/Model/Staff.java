package com.example.demo4.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "gym_key")
    private Gym gym;


    public Staff(long id, String specialty, String phone, String gender, Gym gym) {
        this.id = id;
        this.specialty = specialty;
        this.phone = phone;
        this.gender = gender;
        this.gym = gym;
    }

    public Staff() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecialty(){
        return this.specialty;
    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

}