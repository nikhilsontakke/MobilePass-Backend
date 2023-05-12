package com.example.MobilePass.repository;

import com.example.MobilePass.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
    Employee findByAccessCode(String accessCode);
    Boolean existsByUsername(String username);
    Employee findByUsername(String username);
}
