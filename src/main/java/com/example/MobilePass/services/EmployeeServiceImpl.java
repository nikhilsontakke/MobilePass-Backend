package com.example.MobilePass.services;

import com.example.MobilePass.model.Employee;
import com.example.MobilePass.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    public Boolean employeeDoesNotExist(Integer id) {
        return !employeeRepository.existsById(id);
    }

    public Boolean ifEmployeeExists(String username){
        return employeeRepository.existsByUsername(username);
    }

    public Employee getEmployeeDetailsByUsername(String username){
        return employeeRepository.findByUsername(username);
    }
}
