package com.crud.jpademo.Repository;

import com.crud.jpademo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Optional<Role> findByName(String name);
}
