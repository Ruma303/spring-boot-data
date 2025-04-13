package com.example.demo.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 500)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 500)
    private String lastName;

    @Column(name = "email", nullable = true, length = 200, unique = true)
    private String email;

    @Column(name = "password", nullable = true, length = 200)
    private String password;

    @Column(name = "age", nullable = true)
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    private Course course;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("student")
    private StudentDetail studentDetail;
}