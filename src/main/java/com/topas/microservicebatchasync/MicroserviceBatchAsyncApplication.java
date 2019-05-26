package com.topas.microservicebatchasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

}
