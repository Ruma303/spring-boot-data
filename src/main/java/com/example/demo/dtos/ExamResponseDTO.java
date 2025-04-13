package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResponseDTO {

    private Integer id;
    private StudentExamDTO student;
    private SubjectResponseDTO subject;
    private Date examDate;
    private BigDecimal grade;
}