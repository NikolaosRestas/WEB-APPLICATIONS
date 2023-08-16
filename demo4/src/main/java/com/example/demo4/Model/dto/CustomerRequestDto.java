package com.example.demo4.Model.dto;

import com.example.demo4.Model.Gym;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    private String name;
    private String address;
    private String email;
    private String phone;
    private Long gymId;
}
