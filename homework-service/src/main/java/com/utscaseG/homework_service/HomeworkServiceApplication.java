package com.utscaseG.homework_service;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
@EnableRabbit
public class HomeworkServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HomeworkServiceApplication.class, args);
	}

}
