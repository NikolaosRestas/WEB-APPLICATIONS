package com.example.demo4.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramRequestDto {

    private String kind;
    private String duration;
    private String price;
    private Long customerId;
}