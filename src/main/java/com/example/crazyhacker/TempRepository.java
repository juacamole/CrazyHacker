package com.example.crazyhacker;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TempRepository extends MongoRepository<TempData, String>{}
