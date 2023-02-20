package com.crud.jpademo.Service.impl;

import com.crud.jpademo.Entity.User;
import com.crud.jpademo.Repository.UserRepo;
import com.crud.jpademo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    public Iterable<User> showAll(){
        return userRepo.findAll();
    }
    public void showById(){}
    public void create(){}
    public void delete(){}
    public void update(){}
    public void login(){}
    public void home(){}
}
