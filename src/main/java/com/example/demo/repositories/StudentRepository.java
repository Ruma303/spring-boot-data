package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByLastName(String lastName);

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findStudentsByMinimumAge(int age);
}