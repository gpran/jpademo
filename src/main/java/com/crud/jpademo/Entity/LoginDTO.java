package com.crud.jpademo.Entity;

import lombok.Data;

@Data
public class LoginDTO {
    String usernameOrEmail;
    String password;
}
