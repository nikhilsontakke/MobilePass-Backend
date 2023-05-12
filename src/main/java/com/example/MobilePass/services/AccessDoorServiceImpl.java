package com.example.MobilePass.services;

import com.example.MobilePass.repository.AccessDoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AccessDoorService")
public class AccessDoorServiceImpl implements AccessDoorService{
    @Autowired
    AccessDoorRepository accessDoorRepository;

    public Boolean ifDoorExits(String id) {
        return accessDoorRepository.existsByNfcId(id);
    }
}
