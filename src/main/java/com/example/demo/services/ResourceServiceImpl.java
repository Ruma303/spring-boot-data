package com.example.demo.services;

import com.example.demo.models.Resource;
import com.example.demo.repositories.ResourceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ResourceServiceImpl<T extends Resource> implements ResourceService<T> {

    private final ResourceRepository resourceRepository;
    private final EntityManager entityManager;
    private final Class<T> type;

    @Override
    public T save(T resource) {
        return (T) resourceRepository.save(resource);
    }

    @Override
    public Optional<T> findById(Long id) {
        return resourceRepository.findById(id).map(type::cast);
    }

    @Override
    public List<T> findAll() {
        // query filtrata in base al tipo concreto
        TypedQuery<T> query = entityManager.createQuery(
                "SELECT r FROM " + type.getSimpleName() + " r", type);
        return query.getResultList();
    }

    @Override
    public void delete(Long id) {
        resourceRepository.deleteById(id);
    }
}
