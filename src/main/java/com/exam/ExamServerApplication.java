package com.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.service.UserService;

@SpringBootApplication
public class ExamServerApplication{
	@Autowired
	UserService userservice;
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	
	
}
