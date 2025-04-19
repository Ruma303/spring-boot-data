package com.example.demo.entities;

import com.example.demo.models.AuditMetadata;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "exams")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exam", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_subject", referencedColumnName = "id_subject")
    private Subject subject;

    @Temporal(TemporalType.DATE)
    @Column(name = "exam_date", nullable = false)
    private Date examDate;

    @Column(name = "grade", precision = 3, scale = 1)
    private BigDecimal grade;
}