package com.example.demo.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestDTO {

    @NotBlank(message = "Il nome è obbligatorio")
    @Size(max = 50, message = "Il nome può contenere al massimo 50 caratteri")
    private String firstName;

    @NotBlank(message = "Il cognome è obbligatorio")
    @Size(max = 50, message = "Il cognome può contenere al massimo 50 caratteri")
    private String lastName;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Formato email non valido")
    private String email;

    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 8, max = 100, message = "La password deve contenere almeno 8 caratteri")
    private String password;
}