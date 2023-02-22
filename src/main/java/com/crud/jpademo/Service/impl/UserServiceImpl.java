package com.crud.jpademo.Service.impl;

import com.crud.jpademo.Entity.User;
import com.crud.jpademo.Repository.UserRepo;
import com.crud.jpademo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    public Iterable<User> showAll(){
        return userRepo.findAll();
    }
    public Optional<User> showById(long id){
        return userRepo.findById((int) id);
    }
    public User create(User user){
        //user.setDb_id(ObjectId.get() );
        //user.setDate((Timestamp) new Date());
        user.setDate(new Date());
        return userRepo.save(user);
    }
    public void delete(long id){
        userRepo.deleteById((int)id);
    }
    public void update(long id){
        //userRepo.
    }
    public void login(){}
    public void home(){}
}
