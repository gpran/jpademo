package com.crud.jpademo.Service.impl;

import com.crud.jpademo.Entity.Student;
import com.crud.jpademo.Repository.StudentRepo;
import com.crud.jpademo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    public Iterable<Student> showAll(){
        return studentRepo.findAll();
    }
    public Optional<Student> showById(long id){
        return studentRepo.findById((int) id);
    }
    public Student create(Student student){
        //user.setDb_id(ObjectId.get() );
        //user.setDate((Timestamp) new Date());
        student.setDate(new Date());
        return studentRepo.save(student);
    }
    public void delete(long id){
        studentRepo.deleteById((int)id);
    }
    public String update(long id, Student ur){
        Optional<Student> utemp= studentRepo.findById((int)id);
        Student u1=utemp.get();
        u1.setDb_id(id);
        u1.setName(ur.getName());
        u1.setAge(ur.getAge());
        u1.setStandard(ur.getStandard());
        u1.setSection(ur.getSection());
        studentRepo.save(u1);
        return "User Saved";
    }
    public void login(){}
    public void home(){}
}
