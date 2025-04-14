package com.example.demo.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExamRequestDTO {

    @NotNull(message = "Lo studente è obbligatorio")
    private Integer studentId;

    @NotNull(message = "La materia è obbligatoria")
    private Integer subjectId;

    @NotNull(message = "La data dell'esame è obbligatoria")
    @PastOrPresent(message = "La data non può essere futura")
    private Date examDate;

    @DecimalMin(value = "0.0", message = "Il voto minimo è 0")
    @DecimalMax(value = "30.0", message = "Il voto massimo è 30")
    private BigDecimal grade;
}
