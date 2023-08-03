package com.km.assignment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.km.assignment.repository")
@SpringBootApplication
public class KmAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmAssignmentApplication.class, args);
	}

}
