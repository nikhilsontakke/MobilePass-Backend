package com.example.MobilePass.controller;

import com.example.MobilePass.model.Employee;
import com.example.MobilePass.repository.EmployeeRepository;
import com.example.MobilePass.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Object> getEmployeeDetails(@RequestBody Integer id){
        if(employeeService.employeeDoesNotExist(id)){
            return new ResponseEntity<>("Can't get employee details as employee does not exist.", HttpStatus.NOT_FOUND);
        }
        Optional<Employee> employee = employeeRepository.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        if(employeeService.employeeDoesNotExist(employee.getId())){
            employeeRepository.save(employee);
            return new ResponseEntity<>("Employee added successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee already exists for the corresponding ID.", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee){
        if(employeeService.employeeDoesNotExist(employee.getId())){
            return new ResponseEntity<>("Can't update employee details as employee does not exist.", HttpStatus.NOT_FOUND);
        }
        employeeRepository.save(employee);
        return new ResponseEntity<>("Employee updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteEmployee(@RequestBody Integer id){
        if(employeeService.employeeDoesNotExist(id)){
            return new ResponseEntity<>("Can't delete as employee does not exist.", HttpStatus.NOT_FOUND);
        }
        employeeRepository.deleteById(id);
        return new ResponseEntity<>("Employee deleted successfully.", HttpStatus.OK);
    }
}
