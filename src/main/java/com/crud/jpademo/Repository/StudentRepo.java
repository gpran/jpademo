package com.crud.jpademo.Repository;

import com.crud.jpademo.Entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
}
