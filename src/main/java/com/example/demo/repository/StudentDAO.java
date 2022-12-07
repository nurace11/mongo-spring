package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDAO {
    List<Student> findAll();

    Optional<Student> findStudentById(String id);

    void save(Student student);

    void updateStudent(Student student);

    void deleteStudentById(String id);
}
