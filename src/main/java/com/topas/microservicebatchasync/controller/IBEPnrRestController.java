package com.topas.microservicebatchasync.controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.topas.microservicebatchasync.constant.Constant;
import com.topas.microservicebatchasync.service.PnrUpdate_Service;
import com.topas.microservicebatchasync.vo.Greeting;
import com.topas.microservicebatchasync.vo.PnrUpdate_Service_RQ;
import com.topas.microservicebatchasync.vo.PnrUpdate_Service_RS;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * "/q/select" - 마이크로서비스에서 "/api/q/select" 를 요청하여 가져온 PNR 목록(신규, 실패건)인 존재하면
 * "/pnr/update" - 마이크로서비스에서 "/api/pnr/update" 를 요청하여 비동기로 PNR update 를 한다.
 */
@Slf4j
@RestController
@RequestMapping(path = "/api")
public class IBEPnrRestController {

	@Autowired
	WebClient webClient;

	// 탑승객 정보 관리
//	@Autowired(required = false)
	@Autowired
	private PnrUpdate_Service pnrUpdateSevice;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	
	
	
	
	/**
	 * <pre>
	 * test url
	 * http://localhost:8080/api/self
	 * @param name
	 * @return
	 * </pre>
	 */
	
//	@Async
	@GetMapping("/self")
	public Mono<String> self(@RequestParam(required = false, defaultValue = "World") String name) {
		String currentThread = Thread.currentThread().getName();
		log.info("★★★★★ [self] [IBEPnrRestController]  self =" + "[" + currentThread + "]");

//		Thread.sleep(5000L);

		Mono<String> retrievedResource = webClient.get()
				.uri(Constant.API_ROOT_PATH+ Constant.Q_URI_SELECT).retrieve().bodyToMono(String.class);
//		.uri(Constant.BASE_URL + Constant.REACTIVE + Constant.Q_URI_SELECT).retrieve().bodyToMono(String.class);
		return retrievedResource.map(string -> "We retrieved the following resource using Oauth: " + string);

	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== in greeting ====");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	
	/**
	 * <pre>
	 * run by ScheduledTasks
	 * @param name
	 * @param rq
	 * @return
	 * @throws Exception
	 * </pre>
	 */
	@GetMapping(path = "/q/select")
	public PnrUpdate_Service_RS select(
			
			@RequestParam String ms_currentThread,
			@RequestParam long ms_threadId,
			@RequestParam String ms_requestDate,
			PnrUpdate_Service_RQ rq) throws Exception {
//		Thread.sleep(5000L);
		
		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" +"★★★★★★★★★★★★★ [IBEPnrRestController - select - called ]");
		log.info("[" + currentThread + "]" +"★★★★★★★★★★★★★ [IBEPnrRestController - select - called ]   ms_currentThread = {}, ms_threadId = {}, ms_requestDate = {}", ms_currentThread, ms_threadId, ms_requestDate);
		
		rq.setThreadId(ms_threadId);
		rq.setThreadName(ms_currentThread);
		
		PnrUpdate_Service_RS serviceRS = pnrUpdateSevice.selectPnr(rq);// pnr update 대상건 조회

		return serviceRS;// pnr update 대상건 반환
	}

	/**
	 * <PRE>
	 * 기존 PNR UPDATE 컨트롤러 
	 * 건건이 호출 되어야 함 ?
	 * &#64;param name
	 * &#64;param rq
	 * &#64;return
	 * &#64;throws Exception
	 * </PRE>
	 */
	@GetMapping(path = "/pnr/update")
	public PnrUpdate_Service_RS update(@RequestParam(value = "name", defaultValue = "World") String name,
			PnrUpdate_Service_RQ rq) throws Exception {

		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "[마이크로서비스에서 PNR UPDATE 비동기로 건건이 호출]=" + "[" + currentThread + "]");

		rq.setThreadName(currentThread);
//		rq.setSeq(counter.incrementAndGet());
		PnrUpdate_Service_RS serviceRS = pnrUpdateSevice.updatePnr(rq);// pnr update

		String result = serviceRS.getResult();
		log.info("return serviceRS=" + serviceRS);

		return serviceRS;
	}

	/**
	 * <PRE>
	 * PNR UPDATE 완료 된 경우 Q 삭제 api 콜
	 * Q 방에서 PNR 삭제 시
	 * - 단건인지
	 * - 다중건인지
	 * - 단건 또는 다중건 인지
	 * &#64;param name
	 * &#64;param rq
	 * &#64;return
	 * &#64;throws Exception
	 * </PRE>
	 */
	@GetMapping(path = "/delete")
	public PnrUpdate_Service_RS delete(@RequestParam(value = "name", defaultValue = "World") String name,
			PnrUpdate_Service_RQ rq) throws Exception {

		String currentThread = Thread.currentThread().getName();
		log.info(
				"[" + currentThread + "]" + "[마이크로서비스에서 PNR UPDATE 성공건을 Q 삭제 api 건건이 호출]=" + "[" + currentThread + "]");
		log.info("[" + currentThread + "]" + "[TODO-1] Q 방에서 PNR 건건이 삭제 " + "[" + currentThread + "]");

		rq.setThreadName(currentThread);
		PnrUpdate_Service_RS serviceRS = pnrUpdateSevice.deletePnr(rq);// pnr update

		String result = serviceRS.getResult();
		log.info("return serviceRS=" + serviceRS);

		return serviceRS;
	}
}
