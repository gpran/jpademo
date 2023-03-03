package com.crud.jpademo.Service;

import com.crud.jpademo.Entity.Student;

import java.util.Optional;

public interface StudentService {
    public  Iterable<Student> showAll();
    public Optional<Student> showById(long id);
    public Student create(Student student);
    public void delete(long id);
    public String update(long id, Student ur);
    public void login();
    public void home();
}
