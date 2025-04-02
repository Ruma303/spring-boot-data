package com.example.demo.repositories;

import com.example.demo.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

    List<Exam> findByIdStudent(Integer idStudent);

    List<Exam> findByIdSubject(Integer idSubject);

    @Query("SELECT e FROM Exam e WHERE e.grade >= :minGrade")
    List<Exam> findExamsWithMinGrade(java.math.BigDecimal minGrade);

    @Query("SELECT e FROM Exam e WHERE e.idStudent = :studentId AND e.idSubject = :subjectId")
    List<Exam> findExamsByStudentAndSubject(Integer studentId, Integer subjectId);
}