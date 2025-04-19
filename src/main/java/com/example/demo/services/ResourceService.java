package com.example.demo.services;

import com.example.demo.models.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService<T extends Resource> {
    T save(T resource);
    Optional<T> findById(Long id);
    List<T> findAll();
    void delete(Long id);
}
