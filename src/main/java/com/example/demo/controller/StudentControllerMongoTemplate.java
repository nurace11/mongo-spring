package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentServiceMongoTemplate;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/students")
@AllArgsConstructor
public class StudentControllerMongoTemplate {
    private final StudentServiceMongoTemplate studentService;

    @GetMapping
    public List<Student> fetchAll(){
        return studentService.findAll();
    }

    @GetMapping(path = "{id}")
    public Student fetchStudentById(@PathVariable("id") String id) {
        return studentService.getStudentById(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") String id) {
        studentService.removeStudentById(id);
    }
}
