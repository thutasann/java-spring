package com.thuta.trading_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradingBackendApplication {

	private static final Logger logger = LoggerFactory.getLogger(TradingBackendApplication.class);

	private static final String host = "http://localhost:8080/api/v1";
	private static final String swagger = "http://localhost:8080/swagger-ui/index.html";

	public static void main(String[] args) {
		SpringApplication.run(TradingBackendApplication.class, args);
		logger.info("Trading is running on port " + host + " 🚀");
		logger.info("Swagger is running on " + swagger + " 🚀");
	}

}
