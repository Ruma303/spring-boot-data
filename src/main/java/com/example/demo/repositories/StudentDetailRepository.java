package com.example.demo.repositories;

import com.example.demo.entities.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {

    @Query("SELECT sd FROM StudentDetail sd WHERE sd.address LIKE %:city%")
    java.util.List<StudentDetail> findByAddressContainingCity(String city);
}