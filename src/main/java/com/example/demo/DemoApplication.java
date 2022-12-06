package com.example.demo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository/*, MongoTemplate mongoTemplate*/) {
		return args -> {
			Address address = new Address("Germany", "Cologne", "50441");
			String email = "goewqwrew@gmail.com";
			Student student = new Student(
					"Nelson",
					"Ulrich",
					email,
					Gender.MALE,
					address,
					List.of("Math", "CS"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			repository.findStudentByEmail(email)
					.ifPresentOrElse(s -> {
						System.out.println("Student " + s + " already exists");
					}, () -> {
						System.out.println("Inserting " + student);
						repository.insert(student);
					});

			System.out.println(repository.test());
			System.out.println(repository.findLimit(2));
//			System.out.println(repository.findCount());

/*			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));

			List<Student> students = mongoTemplate.find(query, Student.class);

			if(students.size() > 1) {
				throw new IllegalStateException("Found many students with email " + email);
			}

			if( students.isEmpty()) {
				System.out.println("Inserting " + student);
				repository.insert(student);
			} else {
				System.out.println("Student " + student + " already exists");
			}*/
		};
	}

}
