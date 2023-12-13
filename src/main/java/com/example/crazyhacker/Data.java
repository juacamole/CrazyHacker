package com.example.crazyhacker;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Characters")
public record Data(
        String description,
        String status,
        String id
) {
}
