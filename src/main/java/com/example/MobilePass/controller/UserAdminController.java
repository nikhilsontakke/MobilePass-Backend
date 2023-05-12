package com.example.MobilePass.controller;

import com.example.MobilePass.model.UserAdmin;
import com.example.MobilePass.repository.UserAdminRepository;
import com.example.MobilePass.services.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserAdminController {
    @Autowired
    private UserAdminRepository userRepository;
    @Autowired
    private UserAdminService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Integer id){
        if(userService.userDoesNotExist(id)) {
            return new ResponseEntity<>("Cannot display user as user ID doesn't exist.", HttpStatus.NOT_FOUND);
        }
        Optional<UserAdmin> user = userRepository.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody UserAdmin user){
        if(userService.userDoesNotExist(user.getId())){
            userRepository.save(user);
            return new ResponseEntity<>("User added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("User already exists for the corresponding ID", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody UserAdmin user){
        if(userService.userDoesNotExist(user.getId())) {
            return new ResponseEntity<>("Cannot update user as user ID doesn't exist.", HttpStatus.NOT_FOUND);
        }
        userRepository.save(user);
        return new ResponseEntity<>("User updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Integer id){
        if(userService.userDoesNotExist(id)) {
            return new ResponseEntity<>("Cannot delete user as user ID doesn't exist.", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully.",HttpStatus.OK);
    }
}
