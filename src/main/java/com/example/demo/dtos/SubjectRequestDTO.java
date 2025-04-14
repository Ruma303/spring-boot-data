package com.example.demo.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectRequestDTO {

    @NotBlank(message = "Il nome della materia è obbligatorio")
    @Size(max = 100, message = "Il nome della materia può contenere al massimo 100 caratteri")
    private String subjectName;

    @NotNull(message = "L'insegnante è obbligatorio")
    private Integer idTeacher;
}