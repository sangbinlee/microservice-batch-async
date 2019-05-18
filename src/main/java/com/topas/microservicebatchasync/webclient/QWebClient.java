package com.topas.microservicebatchasync.webclient;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.topas.microservicebatchasync.constant.Constant;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class QWebClient {
	private WebClient webClient = WebClient.create("http://localhost:8080");
	private Mono<ClientResponse> result = webClient.get()
			.uri(Constant.REACTIVE+Constant.Q_URI_SELECT)
//			.accept(MediaType.TEXT_PLAIN)
			.accept(MediaType.APPLICATION_JSON)
			.exchange();

	public String getResult() {
		String currentThread = Thread.currentThread().getName();
		log.info("[QWebClient]  QWebClient =" + "[" + currentThread + "]");
		return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
	}
}
