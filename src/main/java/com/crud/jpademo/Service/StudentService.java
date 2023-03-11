package com.crud.jpademo.Service;

import com.crud.jpademo.Entity.SignUpDTO;
import com.crud.jpademo.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface StudentService {
    public  Iterable<Student> showAll();
    public Optional<Student> showById(long id);
    public Student create(Student student);
    public void delete(long id);
    public String update(long id, Student ur);
    public void login();
    ResponseEntity<?> signup(SignUpDTO signUpDTO);
    public void home();
}
