package com.project.agriculturalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(value="com.project.agriculturalmanagement.repository")

@EntityScan(value="com.project.agriculturalmanagement.entity")
@SpringBootApplication
public class AgriculturalManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(AgriculturalManagementApplication.class, args);
	}

}
