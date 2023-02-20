package com.crud.jpademo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
public class User {
    @Getter
    @Setter
    @Id
    private int db_id;
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
    private Timestamp date;
}
