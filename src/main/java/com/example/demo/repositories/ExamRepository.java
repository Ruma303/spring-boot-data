package com.example.demo.repositories;

import com.example.demo.entities.Exam;
import com.example.demo.entities.Student;
import com.example.demo.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

    List<Exam> findByStudent(Student student);

    List<Exam> findBySubject(Subject subject);

    @Query("SELECT e FROM Exam e WHERE e.grade >= :minGrade")
    List<Exam> findExamsWithMinGrade(BigDecimal minGrade);

    @Query("SELECT e FROM Exam e WHERE e.student.id = :studentId AND e.subject.id = :subjectId")
    List<Exam> findExamsByStudentAndSubject(Integer studentId, Integer subjectId);
}