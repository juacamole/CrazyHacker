package com.example.crazyhacker;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("temp")
public record TempData(
        String description,
        String status,
        String id
) {
}
