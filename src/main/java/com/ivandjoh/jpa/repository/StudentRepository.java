package com.ivandjoh.jpa.repository;

import com.ivandjoh.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
