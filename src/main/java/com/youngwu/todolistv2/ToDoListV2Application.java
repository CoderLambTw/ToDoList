package com.youngwu.todolistv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class ToDoListV2Application {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListV2Application.class, args);
	}
}
