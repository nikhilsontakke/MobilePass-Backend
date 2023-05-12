package com.example.MobilePass.controller;

import com.example.MobilePass.model.AccessDoor;
import com.example.MobilePass.repository.AccessDoorRepository;
import com.example.MobilePass.services.AccessDoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accessdoors")
public class AccessDoorController {
    @Autowired
    AccessDoorRepository accessDoorRepository;
    @Autowired
    AccessDoorService accessDoorService;
    @PostMapping
    public ResponseEntity<Object> addDoor(@RequestBody AccessDoor accessDoor){
        if(!accessDoorService.ifDoorExits(accessDoor.getNfcId())) {
            accessDoorRepository.save(accessDoor);
            return new ResponseEntity<>("Door Details Added Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("This Door Id is Already Added", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping
    public ResponseEntity<Object> deleteDoor(@PathVariable("id") Integer id){
        if(!accessDoorRepository.existsById(id)) {
            return new ResponseEntity<>("Cannot delete door as door ID doesn't exist.", HttpStatus.NOT_FOUND);
        }
        accessDoorRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully.",HttpStatus.OK);
    }
}
