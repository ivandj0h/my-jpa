package com.ivandjoh.jpa.repository;

import com.ivandjoh.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // This is a custom method
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
}
