package com.thutasann.project_management_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagementBackendApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProjectManagementBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementBackendApplication.class, args);
		logger.info("Project Management is running on port http://localhost:8080");
	}

}
