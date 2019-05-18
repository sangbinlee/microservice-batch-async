package com.topas.microservicebatchasync.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.topas.microservicebatchasync.vo.PnrUpdate_Service_RQ;
import com.topas.microservicebatchasync.vo.PnrUpdate_Service_RS;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PnrUpdate_Service {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	/**
	 * pnr update 대상건 조회
	 * @param rq
	 * @return
	 * @throws Exception
	 */
//	@Async
	
	
	public PnrUpdate_Service_RS selectPnr(PnrUpdate_Service_RQ rq) throws Exception {
		
		/**
		 * TODO @Async 사용 할지 테스트  
		 */
		

		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "[서비스 메소드 시작STEP-1]  Q 조회 API 호출(PNR UPDATE용 PNR 목록) =" + "[" + currentThread + "]");
		log.info("[" + currentThread + "]" + "[STEP-1]  Q 조회 API 호출(PNR UPDATE용 PNR 목록) =" + "[" + currentThread + "]");
		log.info("[" + currentThread + "]" + "[STEP-2]  Q 조회 결과 있으면 Q 관리 테이블  저장=" + "[" + currentThread + "]");
		log.info("[" + currentThread + "]" + "[STEP-3]  Q 관리 테이블 PNR 조회(신규 또는 실패)=" + "[" + currentThread + "]");
		
		String ms_currentThread = rq.getThreadName();
		long ms_threadId = rq.getThreadId();
		log.info("[" + currentThread + "]" +"★★★★★★★★★★★★★ [PnrUpdate_Service - select - called ]   ms_currentThread = {}, ms_threadId = {}", ms_currentThread, ms_threadId);

		
		/**
		 * db i/o 작업 처리 시간 
		 */
		Thread.sleep(15000L);
		
		
		PnrUpdate_Service_RS rs = new PnrUpdate_Service_RS(currentThread, ms_threadId, String.format(template, ms_currentThread));
		return rs;
	}
	
	
	/**
	 * <pre>
	 * PNR UPDATE 대상이 
	 * - 단건인지
	 * - 다중건인지
	 * - 단건 또는 다중건 인지
	 * @param rq
	 * @return
	 * @throws Exception
	 * </pre>
	 */
	public PnrUpdate_Service_RS updatePnr(PnrUpdate_Service_RQ rq) throws Exception {
		Thread.sleep(5000L);

		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "[updatePnr]   =" + "[" + currentThread + "]");
		String ms_currentThread = rq.getThreadName();
		long ms_threadId = rq.getThreadId();
		log.info("[" + currentThread + "]" +"★★★★★★★★★★★★★ [PnrUpdate_Service - updatePnr - called ]   ms_currentThread = {}, ms_threadId = {}", ms_currentThread, ms_threadId);
		PnrUpdate_Service_RS rs = new PnrUpdate_Service_RS(currentThread, ms_threadId, String.format(template, ms_currentThread));

		return rs;
	}
	
	
	/**
	 * <pre>
	 * Q 방에서 PNR 삭제 시
	 * - 단건인지
	 * - 다중건인지
	 * - 단건 또는 다중건 인지
	 * @param rq
	 * @return
	 * @throws Exception
	 * </pre>
	 */
	public PnrUpdate_Service_RS deletePnr(PnrUpdate_Service_RQ rq) throws Exception {
		Thread.sleep(5000L);

		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "[deletePnr]   =" + "[" + currentThread + "]");
		String ms_currentThread = rq.getThreadName();
		long ms_threadId = rq.getThreadId();
		log.info("[" + currentThread + "]" +"★★★★★★★★★★★★★ [PnrUpdate_Service - deletePnr - called ]   ms_currentThread = {}, ms_threadId = {}", ms_currentThread, ms_threadId);
		PnrUpdate_Service_RS rs = new PnrUpdate_Service_RS(currentThread, ms_threadId, String.format(template, ms_currentThread));
		return rs;
	}
}
