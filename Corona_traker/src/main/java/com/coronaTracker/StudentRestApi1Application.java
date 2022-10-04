package com.coronaTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentRestApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentRestApi1Application.class, args);
	}

}
