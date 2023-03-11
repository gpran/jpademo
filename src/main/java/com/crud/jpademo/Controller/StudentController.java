package com.crud.jpademo.Controller;

import com.crud.jpademo.Entity.LoginDTO;
import com.crud.jpademo.Entity.SignUpDTO;
import com.crud.jpademo.Entity.Student;
import com.crud.jpademo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AuthenticationManager authenticationManager;
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
    public ResponseEntity<String>  login(LoginDTO loginDTO){
        System.out.println("Login API Called");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);

    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO signUpDTO){
        System.out.println("SignUp API Called");
        return studentService.signup(signUpDTO);
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public @ResponseBody String home(){
        System.out.println("Home API Called");
        return"Home Page";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello World Called");
        return"Hello World!";
    }
}
