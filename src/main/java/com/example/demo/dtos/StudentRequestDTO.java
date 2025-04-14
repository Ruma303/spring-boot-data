package com.example.demo.dtos;

import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

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

    @NotNull(message = "L'età è obbligatoria")
    @Min(value = 18, message = "Età minima 18 anni")
    @Max(value = 100, message = "Età massima 100 anni")
    private Integer age;

    @NotNull(message = "La data di nascita è obbligatoria")
    @Past(message = "La data di nascita deve essere nel passato")
    private Date birthdate;

    @NotNull(message = "Il corso è obbligatorio")
    private Integer courseId;

    public Student toEntity(Course course) {
        Student student = new Student();
        student.setFirstName(this.firstName);
        student.setLastName(this.lastName);
        student.setEmail(this.email);
        student.setPassword(this.password);
        student.setAge(this.age);
        student.setBirthdate(this.birthdate);
        student.setCourse(course);
        return student;
    }
}