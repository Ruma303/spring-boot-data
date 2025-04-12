package com.example.demo.dtos;

import com.example.demo.entities.Course;
import com.example.demo.entities.Student;

import java.util.Date;

public class StudentRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;
    private Date birthdate;
    private Integer courseId;

    // Getters e Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

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