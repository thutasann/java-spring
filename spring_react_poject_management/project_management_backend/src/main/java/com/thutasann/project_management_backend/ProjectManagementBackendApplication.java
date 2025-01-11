package com.thutasann.project_management_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagementBackendApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProjectManagementBackendApplication.class);

	private static final String host = "http://localhost:8080/api/";
	private static final String swagger = "http://localhost:8080/swagger-ui/index.html";

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementBackendApplication.class, args);
		logger.info("Project Management is running on port " + host + " 🚀");
		logger.info("Swagger is running on " + swagger + " 🚀");
	}
}
