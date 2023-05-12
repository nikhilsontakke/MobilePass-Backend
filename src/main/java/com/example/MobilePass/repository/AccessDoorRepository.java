package com.example.MobilePass.repository;


import com.example.MobilePass.model.AccessDoor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessDoorRepository extends MongoRepository<AccessDoor,Integer> {
    Boolean existsById(String doorId);
}
