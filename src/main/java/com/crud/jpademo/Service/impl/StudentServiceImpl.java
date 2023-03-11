package com.crud.jpademo.Service.impl;

import com.crud.jpademo.Entity.Role;
import com.crud.jpademo.Entity.SignUpDTO;
import com.crud.jpademo.Entity.Student;
import com.crud.jpademo.Repository.RoleRepository;
import com.crud.jpademo.Repository.StudentRepo;
import com.crud.jpademo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Iterable<Student> showAll(){
        return studentRepo.findAll();
    }
    public Optional<Student> showById(long id){
        return studentRepo.findById(id);
    }
    public Student create(Student student){
        //user.setDb_id(ObjectId.get() );
        //user.setDate((Timestamp) new Date());
        student.setDate(new Date());
        return studentRepo.save(student);
    }
    public void delete(long id){
        studentRepo.deleteById(id);
    }
    public String update(long id, Student ur){
        Optional<Student> utemp= studentRepo.findById(id);
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

    public ResponseEntity<?> signup(SignUpDTO signUpDTO){
        if(studentRepo.existsByUsername(signUpDTO.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(studentRepo.existsByEmail(signUpDTO.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Student s = new Student();
        s.setName(signUpDTO.getName());
        s.setUsername(signUpDTO.getUsername());
        s.setEmail(signUpDTO.getEmail());
        s.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        System.out.println("Username is: "+s.getUsername());
        Role roles = roleRepository.findByName("ROLE_USER").get();
        s.setRoles(Collections.singleton(roles));

        studentRepo.save(s);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
