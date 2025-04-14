package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDetailRequestDTO {

    @NotBlank(message = "L'indirizzo è obbligatorio")
    private String address;

    private String phone;

    private String taxCode;
}