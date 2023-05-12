package com.example.MobilePass.controller;
import com.example.MobilePass.model.ActivityLog;
import com.example.MobilePass.repository.AccessDoorRepository;
import com.example.MobilePass.repository.ActivityLogRepository;
import com.example.MobilePass.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accesscontrol")
public class AccessController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ActivityLogRepository activityLogRepository;
    @Autowired
    AccessDoorRepository accessDoorRepository;
    @PostMapping
    public ResponseEntity<Object> validateUserAccess(@RequestBody ActivityLog newActivityLog){

        if(employeeService.ifEmployeeExists(newActivityLog.getUsername())){
            if(accessDoorRepository.existsByNfcId(newActivityLog.getDoorId())){
                System.out.println("---------------------------------------");
                System.out.println("Access granted for door ID = "+newActivityLog.getDoorId()+" to employee - "+newActivityLog.getName());
                activityLogRepository.save(newActivityLog);
                return new ResponseEntity<>("Access Granted", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Invalid Door Scanned", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>("Access Denied", HttpStatus.UNAUTHORIZED);
    }

}
