package com.crud.jpademo.Service;

import com.crud.jpademo.Entity.User;

import java.util.Optional;

public interface UserService {
    public  Iterable<User> showAll();
    public Optional<User> showById(long id);
    public User create(User user);
    public void delete(long id);
    public void update(long id);
    public void login();
    public void home();
}
