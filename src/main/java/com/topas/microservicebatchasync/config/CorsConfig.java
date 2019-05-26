package com.topas.microservicebatchasync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String currentThread = Thread.currentThread().getName();
				log.info("★★★★★ [CorsConfig]  corsConfigurer =" + "[" + currentThread + "]");
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
			}
		};
	}
}
