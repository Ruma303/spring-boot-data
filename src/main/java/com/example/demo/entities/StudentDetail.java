package com.example.demo.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetail {

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_student")
    private Student student;

    @Id
    @Column(name = "id_student", nullable = false)
    private Integer idStudent;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
}