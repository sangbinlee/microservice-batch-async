package com.topas.microservicebatchasync.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableScheduling

//public class SchedulerConfiguration implements SchedulingConfigurer {
public class SchedulerConfig {

//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(100);
//        taskScheduler.initialize();
//        taskRegistrar.setTaskScheduler(taskScheduler);
//    }
//    @Bean
//    public ScheduledTasks scheduledTasks() {
//        return new ScheduledTasks();
//    }


//	@Scheduled(fixedRate = 2000) // 수행 시작 기점, 2초 후 실행
//	public void fixedRateTest() {
//		log.info("ScheduleConfig fixedRateTest. " + Thread.currentThread().getName());
//		System.out.println("fixedRate: 2sec -> " + new Date());
//
//	}
	
//	@Scheduled(fixedRate = 2000) // 수행 시작 기점, 2초 후 실행
//	public void testSchedule() throws Exception {
//		log.info("SchedulerConfiguration testSchedule. " + Thread.currentThread().getName());
////		Thread.sleep(15000L);
//		System.out.println("fixedRate: 2sec -> " + new Date());
//	}

//	@Scheduled(fixedRate = 2000) // 수행 시작 기점, 2초 후 실행
//	@Scheduled(fixedRate = 10) // 수행 시작 기점, 2초 후 실행
//	public void testSchedule() throws Exception {
//		log.info("xxxxxxxxxxxx SchedulerConfiguration testSchedule. " + Thread.currentThread().getName());
////		Thread.sleep(15000L);
////		log.info("xxxxxxxxxxxx fixedRate: 2sec -> " + new Date());
//
//	}
 

}
