package com.topas.microservicebatchasync.component;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.topas.microservicebatchasync.service.AsyncService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Scheduler {

	@Autowired
	private AsyncService service;

	@Scheduled(fixedRate = 2000) // 수행 시작 기점, 2초 후 실행
	public void fixedRateTest() throws Exception {

		log.info("fixedRateTest. " + Thread.currentThread().getName());

		System.out.println("@Component fixedRate: 2sec -> " + new Date());

		service.taskExecutor100();
	}

	@Scheduled(fixedDelay = 7000) // 수행 종료 기점, 7초 후 실행
	public void fixedDelayTest() {
		System.out.println("fixedDelay: 7sec -> " + new Date());
	}

//	@Scheduled(cron = "0 0 13 * * *") // 매일 13시 수행
//	public void cronTest() {
//		System.out.println("cron: 0 0 13 * * * -> " + new Date());
//	}
}