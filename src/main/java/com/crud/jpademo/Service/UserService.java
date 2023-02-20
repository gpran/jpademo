package com.crud.jpademo.Service;

import com.crud.jpademo.Entity.User;

public interface UserService {
    public  Iterable<User> showAll();
    public void showById();
    public void create();
    public void delete();
    public void update();
    public void login();
    public void home();
}
