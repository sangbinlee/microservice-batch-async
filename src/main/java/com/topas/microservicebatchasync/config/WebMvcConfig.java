package com.topas.microservicebatchasync.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.topas.microservicebatchasync.intercepter.LoginInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableAsync
public class WebMvcConfig implements WebMvcConfigurer {
	

	@Autowired
	@Qualifier(value = "httpInterceptor")
	private HandlerInterceptor interceptor;

	

	@Autowired
	private LoginInterceptor loginInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(interceptor)
//				.addPathPatterns("/**")
//				.excludePathPatterns("/user/**");
		
		

		registry.addInterceptor(loginInterceptor)
			.addPathPatterns("/boards/view/**")
			.addPathPatterns("/boards/write/**")
			.addPathPatterns("/boards/update/**")
			.addPathPatterns("/boards/delete/**");
	}
}
