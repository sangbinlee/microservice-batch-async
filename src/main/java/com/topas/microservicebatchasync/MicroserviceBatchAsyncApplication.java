package com.topas.microservicebatchasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MicroserviceBatchAsyncApplication {
//	public class MicroserviceBatchAsyncApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(MicroserviceBatchAsyncApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBatchAsyncApplication.class, args);
	}

	
	
	/**
	 * TODO LIST
	 * 					1. BATCH JOB
	 * 
	 */
}
