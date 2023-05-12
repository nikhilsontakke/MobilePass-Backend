package com.example.MobilePass.controller;

import com.example.MobilePass.model.AccessDoor;
import com.example.MobilePass.model.UserAdmin;
import com.example.MobilePass.repository.AccessDoorRepository;
import com.example.MobilePass.services.AccessDoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accessdoors")
public class AccessDoorController {
    @Autowired
    AccessDoorRepository accessDoorRepository;
    @Autowired
    AccessDoorService accessDoorService;
    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody AccessDoor accessDoor){
        if(accessDoorService.ifDoorExits(accessDoor.getId())) {
            accessDoorRepository.save(accessDoor);
            return new ResponseEntity<>("Door Details Added Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("This Door Id is Already Added", HttpStatus.NOT_FOUND);
    }
}
