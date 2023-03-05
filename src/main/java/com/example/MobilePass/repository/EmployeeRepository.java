package com.example.MobilePass.repository;

import com.example.MobilePass.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
    Employee findByAccessCode(String accessCode);
    Employee findByUsername(String username);
}
