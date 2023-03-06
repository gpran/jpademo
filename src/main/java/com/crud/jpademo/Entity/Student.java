package com.crud.jpademo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Data
@Entity
@Table(name="student", uniqueConstraints={
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long db_id;
    private String name;
    private int age;
    private int standard;
    private String section;
    private Date date;
    private String username;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "student_roles",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "db_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
