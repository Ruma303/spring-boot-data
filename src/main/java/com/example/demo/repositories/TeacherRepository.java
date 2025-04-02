package com.example.demo.repositories;

import com.example.demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByLastName(String lastName);

    List<Teacher> findByFirstNameAndLastName(String firstName, String lastName);
}