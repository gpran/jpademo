package com.crud.jpademo.Controller;

import com.crud.jpademo.Entity.Student;
import com.crud.jpademo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Student> showAll(){
        return studentService.showAll();
    }

    @RequestMapping(value = "/showById/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Student> showById(@PathVariable(value= "id") long id){
        return studentService.showById(id);
        //return"Hello!";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Student create(@RequestBody Student student){
        return studentService.create(student);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String delete(@PathVariable(value= "id") long id){
        studentService.delete(id);
        return "Deleted";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public @ResponseBody String update(@PathVariable(value= "id") long id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String login(){
        return"Login Success!";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public @ResponseBody String home(){
        return"Home Page";
    }
}
