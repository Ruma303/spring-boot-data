package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseRequestDTO {

    @NotBlank(message = "Il nome del corso è obbligatorio")
    @Size(max = 100, message = "Il nome del corso può contenere al massimo 100 caratteri")
    private String courseName;
}