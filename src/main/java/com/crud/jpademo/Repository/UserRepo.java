package com.crud.jpademo.Repository;

import com.crud.jpademo.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
