package com.example.MobilePass.services;

import com.example.MobilePass.model.Employee;
import com.example.MobilePass.model.UserAdmin;
import com.example.MobilePass.repository.EmployeeRepository;
import com.example.MobilePass.repository.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserAdminRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Boolean validateUser(String username, String password){
        UserAdmin user = userRepository.findByUsername(username);
        return user!=null && user.getPassword().equals(password);
    }

    public Boolean validateEmployee(String username, String password){
        Employee employee = employeeRepository.findByUsername(username);
        return employee!=null && employee.getPassword().equals(password);
    }
}
