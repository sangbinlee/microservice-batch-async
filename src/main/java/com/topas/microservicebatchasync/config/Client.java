package com.topas.microservicebatchasync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.topas.microservicebatchasync.constant.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class Client {

	@Bean
	WebClient getWebClient() {
		String currentThread = Thread.currentThread().getName();
		log.info("★★★★★ [Client]  getWebClient =" + "[" + currentThread + "]");
        return WebClient.create(Constant.BASE_URL);

//		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(Constant.BASE_URL);
//		URI uri = uriBuilderFactory.uriString(Constant.REACTIVE + Constant.Q_URI_SELECT).queryParam("q", "xxx")
//				.build("Westin", "123");

//		return WebClient.builder().uriBuilderFactory(uriBuilderFactory).build();
//		return WebClient.builder().build();
	}
//	@Bean
//	public RouterFunction<ServerResponse> route(QHandler qHandler) {
//
//		String currentThread = Thread.currentThread().getName();
//		log.info("[route]  route =" + "[" + currentThread + "]");
//
//		return RouterFunctions.route(
////				RequestPredicates.GET(Constant.REACTIVE+Constant.Q_URI_SELECT).and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
//				RequestPredicates.GET(Constant.REACTIVE + Constant.Q_URI_SELECT)
//						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
//				qHandler::select);
//	}
}
