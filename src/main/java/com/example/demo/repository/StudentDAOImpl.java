package com.example.demo.repository;

import ch.qos.logback.core.model.ImplicitModel;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDAOImpl implements StudentDAO{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public Optional<Student> findStudentById(String id) {
        return Optional.ofNullable(mongoTemplate.findOne(new Query().addCriteria(Criteria.where("id").is(id)),
                Student.class));
    }

    @Override
    public void save(Student student) {
        mongoTemplate.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        mongoTemplate.update(Student.class);
    }

    public void updateFirstNameById(String id, String newFirstName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("firstName", newFirstName);
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    @Override
    public void deleteStudentById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Student.class)/*.wasAcknowledged()*/;
    }
}
