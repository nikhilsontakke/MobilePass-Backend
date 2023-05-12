package com.example.MobilePass.services;

import com.example.MobilePass.repository.AccessDoorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccessDoorImpl implements AccessDoorService{
    @Autowired
    AccessDoorRepository accessDoorRepository;
    @Override
    public Boolean ifDoorExits(String doorId) {
        return accessDoorRepository.existsById(doorId);
    }
}
