package com.crud.jpademo.Controller;

import com.crud.jpademo.Entity.User;
import com.crud.jpademo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> showAll(){
        return userService.showAll();
    }

    @RequestMapping(value = "/showById", method = RequestMethod.GET)
    public @ResponseBody String showById(){
        return"Hello!";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody String create(){
        return"Hello!";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody String delete(){
        return"Hello!";
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
