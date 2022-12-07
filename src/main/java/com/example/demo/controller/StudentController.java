package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student fetchStudentById(@PathVariable("id") String id) {
        return studentService.getStudentById(id);
    }

    @PutMapping(path = "{id}")
    public int updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @PostMapping
    public int addStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    @DeleteMapping("{id}")
    public int deleteStudent(@PathVariable("id") String id) {
        return studentService.removeStudentById(id);
    }
}
