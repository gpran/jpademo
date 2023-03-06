package com.crud.jpademo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SignUpDTO {
    String name;
    String username;
    String email;
    String password;
}
