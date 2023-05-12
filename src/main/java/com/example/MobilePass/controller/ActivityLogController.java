package com.example.MobilePass.controller;

import com.example.MobilePass.model.ActivityLog;
import com.example.MobilePass.repository.ActivityLogRepository;
import com.example.MobilePass.services.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

//@CrossOrigin(origins = "http://localhost:4200/home")
@RequestMapping("/activitylogs")
public class ActivityLogController {
    @Autowired
    ActivityLogService activityLogService;
    @Autowired
    ActivityLogRepository activityLogRepository;
    @CrossOrigin("*")
    @GetMapping()
    public ResponseEntity<Object> getAllActivities(){
        return new ResponseEntity<>(activityLogService.getAllRecords(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveActivity(@RequestBody ActivityLog activityLog){
        activityLogRepository.save(activityLog);
        return new ResponseEntity<>("Activity Logged Successfully", HttpStatus.OK);
    }

}
