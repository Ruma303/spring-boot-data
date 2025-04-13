package com.example.demo.dtos;

import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;
    private Date birthdate;
    private Integer courseId;

    // Metodo statico per convertire in Student (richiede Course come parametro)
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