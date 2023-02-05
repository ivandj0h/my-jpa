package com.ivandjoh.jpa.repository;

import com.ivandjoh.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("dave")
                .lastName("djoh")
                .emailId("ivandi@gmail.com")
                .guardianName("ivandjoh")
                .guardianEmail("g@google.com")
                .guardianMobile("123456789")
                .build();
        studentRepository.save(student);
    }
}