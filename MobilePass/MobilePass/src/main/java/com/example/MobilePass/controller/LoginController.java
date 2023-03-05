package com.example.MobilePass.controller;

import com.example.MobilePass.model.Employee;
import com.example.MobilePass.model.UserAdmin;
import com.example.MobilePass.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/useradmin")
    public ResponseEntity<Object> validateUserAdminLoginSession(@RequestBody UserAdmin user){
        if(loginService.validateUser(user.getUsername(), user.getPassword())){
            return new ResponseEntity<>("User Logged-In Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Invalid login credentials", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<Object> validateEmployeeLoginSession(@RequestBody Employee employee){
        if(loginService.validateEmployee(employee.getUsername(), employee.getPassword())){
            return new ResponseEntity<>("Employee Logged-In Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Invalid login credentials", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
