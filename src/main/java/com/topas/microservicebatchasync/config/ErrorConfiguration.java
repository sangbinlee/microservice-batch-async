package com.topas.microservicebatchasync.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ErrorConfiguration implements
WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>  {
	public void customize(ConfigurableServletWebServerFactory container) {
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//		container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/WEB-INF/error/401.jsp"));
//		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/error/500.jsp"));
	}
}
