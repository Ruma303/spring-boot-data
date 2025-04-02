package com.example.demo.repositories;

import com.example.demo.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    List<Subject> findBySubjectName(String subjectName);

    @Query("SELECT s FROM Subject s WHERE s.idTeacher = :teacherId")
    List<Subject> findByTeacherId(Integer teacherId);
}