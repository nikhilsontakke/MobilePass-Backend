package com.example.MobilePass.repository;

import com.example.MobilePass.model.UserAdmin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAdminRepository extends MongoRepository<UserAdmin, Integer> {
    UserAdmin findByUsername(String username);
}
