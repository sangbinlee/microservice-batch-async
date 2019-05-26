package com.topas.microservicebatchasync.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableScheduling
public class ScheduleConfig {

//	log.info("[ScheduleConfig]. " + Thread.currentThread().getName());

	@Scheduled(fixedRate = 2000) // 수행 시작 기점, 2초 후 실행
	public void fixedRateTest() {
		log.info("ScheduleConfig fixedRateTest. " + Thread.currentThread().getName());
		System.out.println("fixedRate: 2sec -> " + new Date());

	}
}
