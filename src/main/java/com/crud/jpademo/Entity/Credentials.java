package com.crud.jpademo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Credentials {
    @Getter
    @Setter
    @Id
    private int db_id;
    @Getter
    @Setter
    String username;
    @Getter
    @Setter
    String password;
    @Getter
    @Setter
    String token;
}
