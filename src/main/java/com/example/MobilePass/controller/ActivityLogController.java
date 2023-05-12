package com.example.MobilePass.controller;

import com.example.MobilePass.services.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activitylogs")
public class ActivityLogController {
    @Autowired
    ActivityLogService activityLogService;

    @GetMapping
    public ResponseEntity<Object> getAllActivities(){
        return new ResponseEntity<>(activityLogService.getAllRecords(), HttpStatus.OK);
    }

}
