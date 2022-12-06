package com.example.demo.repository;


import com.example.demo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findStudentByEmail(String email);


    @Query("db.student.find()")
    List<Student> test();

    @Query("db.student.find().limit(?)")
    List<Student> findLimit(int limit);

//    @Query("db.student.find().count()")
//    int findCount();
}
