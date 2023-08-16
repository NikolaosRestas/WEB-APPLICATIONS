package com.example.demo4.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymRequestDto {

    private String name;
    private String address;
    private Long countyId;
}
