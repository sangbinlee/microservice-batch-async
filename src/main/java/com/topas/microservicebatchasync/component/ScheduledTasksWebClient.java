/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.topas.microservicebatchasync.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.topas.microservicebatchasync.constant.Constant;
import com.topas.microservicebatchasync.vo.PnrUpdate_Service_RS;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ScheduledTasksWebClient {

//	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	WebClient webClient;

//	@Scheduled(fixedRate = 5000) // 2000 = 2 seconds
//	@Scheduled(cron = "*/5 * * * * *" ) // 5초마다
//	@Scheduled(cron = "*/1 * * * * *" ) // 1초마다
//	@Scheduled(cron = "*/10 * * * * *") // 10초마다
	public void task() throws Exception {

		/**
		 * 구현할 목록 1. @CrossOrigin(origins = "http://localhost:9000")
		 * 2. @CrossOrigin(origins = "http://domain1.com, http://domain2.com") 3. filter
		 * set or config set by @CrossOrigin  
		 */

		/**
		 * cf. ms = 마이크로서비스 TODO TASK STEP 1. q select 2. pnr update
		 * 
		 * 마이크로 서비스 - MS 스케줄 5초 간격 REST API 메소드 호출(WEBCLIENT )
		 * http://localhost:8080/api/q/select
		 * 
		 * IBE 서버 REST API 메소드 - 서비스 메소드 호출 SERVICE STEP STEP 1. Q 조회 API 호출 STEP 2. Q
		 * 조회 API 호출 결과 존재시 Q 관리 테이블 (상태 : 신규 ) INSERT STEP 3. Q 조회 API 호출 결과 존재시 Q 관리
		 * 테이블 (상태 : 신규 ) INSERT - 성공시 목록 조회 (조회조건 : 신규 또는 실패) STEP 4. 목록 조회 성공시 Q 관리
		 * 테이블 (상태:진행중 ) UPDATE STEP 5. 목록 조회 성공시 Q 관리 테이블 (상태:진행중 ) UPDATE - 성공시 PNR
		 * UPDATE - 병렬 처리
		 * 
		 *
		 * 
		 */

		long threadId = counter.incrementAndGet();

		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "★★★★★★★★★★★★★ [MS - ]");
		log.info("[" + currentThread + "]"
				+ "★★★★★★★★★★★★★ [MS - Scheduled (5초 간격) TASK 시작 - {} - REST API 메소드 호출 ( WEBCLIENT ) ] - The time is now {}",
				threadId, dateFormat.format(new Date()));

		// case 0

//		log.info("★★★★ [ BLOCKING ] time is now {}", dateFormat.format(new Date()));

		/**
		 * with blocking
		 */
//		Mono<ClientResponse> result = webClient.get()
//				.uri(Constant.API_ROOT_PATH+Constant.Q_URI_SELECT)
////				.accept(MediaType.TEXT_PLAIN)
//				.accept(MediaType.APPLICATION_JSON)
//				.exchange()
//				;
//		System.out.println(">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block());
//		log.error(">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block());

		/**
		 * Getting Response Without Blocking
		 */
		Mono<PnrUpdate_Service_RS> result =
//				webClient.get().uri(Constant.API_ROOT_PATH + Constant.Q_URI_SELECT).retrieve()

				this.webClient.get()
						.uri(uriBuilder -> uriBuilder.path(Constant.API_ROOT_PATH + Constant.Q_URI_SELECT)
								.queryParam("ms_currentThread", currentThread).queryParam("ms_threadId", threadId)
								.queryParam("ms_requestDate", dateFormat.format(new Date())).build())
						.retrieve()

						.bodyToMono(PnrUpdate_Service_RS.class);

		result.subscribe(ScheduledTasksWebClient::handleResponse);

//		System.out.println("After subscribe");
		// wait for a while for the response
//		Thread.sleep(1000);

//		for (int i = 0; i < 50; i++) {
//			long id = counter.incrementAndGet();
//			
//			/**
//			 * TODO id and i 값을 파라미터로 세팅 하는 부분 구현하기 
//			 */
//			
//			Mono<String> result = webClient.get().uri(Constant.API_ROOT_PATH + Constant.Q_URI_SELECT).retrieve()
//					.bodyToMono(String.class);
//			result.subscribe(ScheduledTasks::handleResponse);
//			System.out.println("After subscribe");
//			// wait for a while for the response
////			Thread.sleep(1000);
//		}

		log.info("[" + currentThread + "]"
				+ "★★★★★★★★★★★★★ [MS - Scheduled (5초 간격) TASK 끝 - {} - REST API 메소드 호출 ( WEBCLIENT ) ] - The time is now {}",
				threadId, dateFormat.format(new Date()));

//		 webClient.get()
//	      .uri("http://localhost:8084/retrieve-resource")
//	      .uri(Constant.REACTIVE+Constant.Q_URI_SELECT)
//	      .accept(MediaType.APPLICATION_JSON)
//			.exchange()
//	      .retrieve()
//	      .bodyToMono(String.class)
//	      .map(string 
//	        -> "Retrieved using Client Credentials Grant Type: " + string)
//	      .subscribe(logger::info)
//	      .subscribe(log::info)
		;
//		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(Constant.BASE_URL);
////		URI uri = uriBuilderFactory.uriString("/hotels/{hotel}").queryParam("q", "{q}").build("Westin", "123");
//		URI uri = uriBuilderFactory.uriString(Constant.REACTIVE+Constant.Q_URI_SELECT).queryParam("q", "{q}").build("Westin", "123");
//		WebClient client = WebClient.builder().uriBuilderFactory(uriBuilderFactory).build();

		// case 1 response xxxx
//		QWebClient qWebClient = new QWebClient();
//		System.out.println(qWebClient.getResult());

		// case 2 xxxxx
//		 Mono<ClientResponse> result = webClient.get()
//					.uri(Constant.REACTIVE+Constant.Q_URI_SELECT)
////					.accept(MediaType.TEXT_PLAIN)
//					.accept(MediaType.APPLICATION_JSON)
//					.exchange();
//		
//
//			System.out.println(
//					">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block()
//					);

//		WebClient client = WebClient.create("http://localhost:8080");
//		Mono<ClientResponse> result = client.get()
//				.uri("/hello")
//				.accept(MediaType.TEXT_PLAIN)
//				.exchange();
//		System.out.println(
//				">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block()
//				);

//		log.info("★ [ JOB-2. [ms] PNR UPDATE 건건이 호출 (async - webclient)]---  The time is now {}",
//				dateFormat.format(new Date()));
//		log.info("[STEP-1]  PNR UPDATE 용  파라미터 세팅 =" + "[" + currentThread + "]");
//
//		log.info("★ [ JOB-3. [ms] PNR UPDATE 성공시 Q 삭제 API 건건이 호출(async - webclient) ]---  The time is now {}",
//				dateFormat.format(new Date()));
//		log.info("★★★★★ [@Scheduled --- 끝 ]---  The time is now {}", dateFormat.format(new Date()));

	}

	private static void handleResponse(PnrUpdate_Service_RS rs) {
		String currentThread = Thread.currentThread().getName();
		long rsThreadId = rs.getThreadId();
		String rsThreadName = rs.getThreadName();
		log.info("[" + currentThread + "]"
				+ "★★★★★★★★★★★★★ [MS - Scheduled (5초 간격) TASK [응답결과] 시작 - {} - REST API 메소드 호출 ( WEBCLIENT ) ] - The time is now {}",
				rsThreadId, dateFormat.format(new Date()));
		log.info("[" + currentThread + "]"
				+ "★★★★★★★★★★★★★ [MS - Scheduled (5초 간격) TASK [응답결과] rsThreadId = {} - rsThreadName = {} - rs.toString() = {}",
				rsThreadId, rsThreadName, rs.toString());

		log.info("[" + currentThread + "]"
				+ "★★★★★★★★★★★★★ [MS - Scheduled (5초 간격) TASK [응답결과] 끝 - {} - REST API 메소드 호출 ( WEBCLIENT ) ] - The time is now {}",
				rsThreadId, dateFormat.format(new Date()));
	}

}
