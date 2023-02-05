package com.ivandjoh.jpa.repository;

import com.ivandjoh.jpa.entity.Guardian;
import com.ivandjoh.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("ivan")
                .email("ivandjoh@gmail.com")
                .mobile("081234567890")
                .build();

        Student student = Student.builder()
                .firstName("dave")
                .lastName("djoh")
                .emailId("dave.djoh@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("dave");
        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("dav");
        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("ivan");
        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentsByEmailAddress("dave.djoh@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentsByEmailAddressNative("dave.djoh@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentsByEmailAddressNativeNamedParam("dave.djoh@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        int result = studentRepository.updateStudentNameByEmailId("dave djoh", "dave.djoh@gmail.com");
        System.out.println("result = " + result);
    }
}