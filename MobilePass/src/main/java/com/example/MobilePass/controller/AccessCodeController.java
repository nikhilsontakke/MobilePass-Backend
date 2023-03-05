package com.example.MobilePass.controller;

import com.example.MobilePass.model.Employee;
import com.example.MobilePass.repository.EmployeeRepository;
import com.example.MobilePass.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accesscode")
public class AccessCodeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;

    @PutMapping
    public ResponseEntity<Object> updateAccessCode(@RequestBody Employee employee){
        if(employeeService.employeeDoesNotExist(employee.getId())){
            return new ResponseEntity<>("Invalid employee details", HttpStatus.UNAUTHORIZED);
        }
        Employee dbEmployeeDetails = employeeRepository.findById(employee.getId()).get();
        dbEmployeeDetails.setAccessCode(employee.getAccessCode());
        employeeRepository.save(dbEmployeeDetails);
        return new ResponseEntity<>("Access code updated successfully", HttpStatus.OK);
    }

}
