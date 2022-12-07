package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentDAOImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class StudentServiceMongoTemplate {
    private StudentDAOImpl studentDAO;

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    public Student getStudentById(String id) {
        return studentDAO.findStudentById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " not found"));
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void insertStudent(Student student) {
        studentDAO.save(student);
    }

    public void removeStudentById(String id) {
        studentDAO.deleteStudentById(id);
    }
}
