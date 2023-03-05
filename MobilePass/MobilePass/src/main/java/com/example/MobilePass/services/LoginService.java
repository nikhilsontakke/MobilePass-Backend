package com.example.MobilePass.services;

public interface LoginService {
    public Boolean validateUser(String username, String password);
    public Boolean validateEmployee(String username, String password);
}
