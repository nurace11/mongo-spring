package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional// for daoImpl
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " NOT FOUND"));
    }

    public int updateStudent(Student student) {
        try {
            getStudentById(student.getId());
            studentRepository.save(student);
            return 1;
        } catch (IllegalStateException e) {
            return 0;
        }
    }

    public int insertStudent(Student student) {
        try {
            studentRepository.insert(student);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int removeStudentById(String id) {
        try{
            studentRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
