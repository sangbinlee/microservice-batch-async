package com.topas.microservicebatchasync.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.topas.microservicebatchasync.service.AsyncService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SchedulerTasksAsyncService {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private AsyncService service;

//	@Scheduled(fixedRate = 1000) // 수행 시작 기점, 2초 후 실행
//	@Scheduled(fixedRate = 5000) // 2000 = 2 seconds
//	@Scheduled(cron = "*/5 * * * * *") // 5초마다
//	@Scheduled(cron = "0/5 * * * * *") // 5초마다
//	@Scheduled(fixedDelayString = "5000")
	public void fixedRateTest() throws Exception {
		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "★★★ [SchedulerTasksAsyncService taskExecutor100 호출 시작 -  time = {}",
				dateFormat.format(new Date()));
		
		service.taskExecutor100();
		
		log.info("[" + currentThread + "]" + "★★★ [SchedulerTasksAsyncService taskExecutor100 호출 종료 -  time = {}",
				dateFormat.format(new Date()));
	}

//	@Scheduled(fixedDelay = 7000) // 수행 종료 기점, 7초 후 실행
	public void fixedDelayTest() {
		System.out.println("fixedDelay: 7sec -> " + new Date());
	}

//	@Scheduled(cron = "0 0 13 * * *") // 매일 13시 수행
	public void cronTest() {
		System.out.println("cron: 0 0 13 * * * -> " + new Date());
	}
}




