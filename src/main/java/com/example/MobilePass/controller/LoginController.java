package com.example.MobilePass.controller;

import com.example.MobilePass.model.Employee;
import com.example.MobilePass.model.UserAdmin;
import com.example.MobilePass.repository.EmployeeRepository;
import com.example.MobilePass.services.EmployeeService;
import com.example.MobilePass.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @CrossOrigin("*")
    @PostMapping("/useradmin")
    public ResponseEntity<List<String>> validateUserAdminLoginSession(@RequestBody UserAdmin user){
        List<String> responseMessage = new ArrayList<>();
        if(loginService.validateUser(user.getUsername(), user.getPassword())){
            responseMessage.add("User Logged-In Successfully");
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }else{
            responseMessage.add("Invalid login credentials");
            return new ResponseEntity<>(responseMessage, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> validateEmployeeLoginSession(@RequestBody Employee employee){
        if(loginService.validateEmployee(employee.getUsername(), employee.getPassword())){
            Employee employeeDetails = employeeService.getEmployeeDetailsByUsername(employee.getUsername());
            return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Invalid login credentials", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
