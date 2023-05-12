package com.example.MobilePass.services;

import com.example.MobilePass.model.Employee;


public interface EmployeeService {
    public Boolean employeeDoesNotExist(Integer id);
    public Boolean ifEmployeeExists(String username);
    Employee getEmployeeDetailsByUsername(String username);
}
