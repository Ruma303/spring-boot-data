package com.example.demo.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentExamDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}