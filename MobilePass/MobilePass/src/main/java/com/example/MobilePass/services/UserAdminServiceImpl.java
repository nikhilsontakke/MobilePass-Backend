package com.example.MobilePass.services;

import com.example.MobilePass.repository.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserAdminService")
public class UserAdminServiceImpl implements UserAdminService {
    @Autowired
    UserAdminRepository userRepository;

    public Boolean userDoesNotExist(Integer id){
        return !userRepository.existsById(id);
    }
}
