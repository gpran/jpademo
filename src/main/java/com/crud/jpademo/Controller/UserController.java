package com.crud.jpademo.Controller;

import com.crud.jpademo.Entity.User;
import com.crud.jpademo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> showAll(){
        return userService.showAll();
    }

    @RequestMapping(value = "/showById/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<User> showById(@PathVariable(value= "id") long id){
        return userService.showById(id);
        //return"Hello!";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody User create(@RequestBody User user){
        return userService.create(user);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String delete(@PathVariable(value= "id") long id){
        userService.delete(id);
        return "Deleted";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody String update(){
        return"Hello!";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String login(){
        return"Hello!";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public @ResponseBody String home(){
        return"Hello!";
    }
}
