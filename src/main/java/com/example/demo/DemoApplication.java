package com.example.demo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			Address address = new Address("Germany", "Cologne", "50441");
			Student student = new Student(
					"Nelson",
					"Ulrich",
					"golloasldwmi@gmail.com",
					Gender.MALE,
					address,
					List.of("Math", "CS"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			repository.insert(student);
		};
	}

}
