package com.crud.jpademo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
public class Student {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long db_id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private int standard;
    @Getter
    @Setter
    private String section;
    @Getter
    @Setter
    private Date date;
}
