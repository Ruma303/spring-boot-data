package com.example.demo.entities;

public enum StudentStatus {
    ACTIVE,
    INACTIVE,
    GRADUATED,
    DROPPED_OUT,
    UNKNOWN;

    public static StudentStatus fromString(String status) {
        if (status == null || status.isBlank()) {
            return UNKNOWN;
        }

        // Normalizzazione: rimuove spazi, underscore, trattini, converte in MAIUSCOLO
        String normalized = status
                .trim()
                .replaceAll("[\\s_-]", "")   // Rimuove spazi, underscore e trattini
                .toUpperCase();

        for (StudentStatus s : StudentStatus.values()) {
            String enumNormalized = s.name().replaceAll("_", "");
            if (enumNormalized.equals(normalized)) {
                return s;
            }
        }

        return UNKNOWN;
    }
}