package com.example.demo.models;

import java.time.LocalDateTime;

public record AuditMetadata(
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String createdBy,
        String updatedBy
) {}
