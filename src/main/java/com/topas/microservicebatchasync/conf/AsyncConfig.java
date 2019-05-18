package com.topas.microservicebatchasync.conf;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.topas.microservicebatchasync.handler.CustomAsyncExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(500);
		executor.setMaxPoolSize(500);
		executor.setQueueCapacity(0);
		executor.setThreadNamePrefix("[thread] GithubLookup-");
		executor.initialize();
		return executor;
	}

	@Bean(name = "taskExecutor3")
	public Executor taskExecutor3() {
		log.info("taskExecutor3. " + Thread.currentThread().getName());
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);// 쓰레드가 모두 처리중일때 추가 요청이 들어오면 대기열에 적재 , 쓰레드 종료시 까지 기다림
		executor.setQueueCapacity(500);// 설정한 사이즈 만큼 대기열로 들어가 처리를 기다리고, 돌고 있는 쓰레드가 종료되면 순차적으로 처리 , 쓰레드와 큐가 모두 꽉차게 되면
										// Exception이 발생
		executor.setThreadNamePrefix("[thread] taskExecutor100-");
		executor.initialize();
		return executor;
	}

	@Bean(name = "taskExecutor100")
	public Executor taskExecutor100() {
		log.info("taskExecutor100. " + Thread.currentThread().getName());
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(100);
		executor.setMaxPoolSize(500);// 쓰레드가 모두 처리중일때 추가 요청이 들어오면 추가로 쓰레드가 500 개 생성
		executor.setQueueCapacity(10);// 설정한 사이즈 만큼 대기열로 들어가 처리를 기다리고, 돌고 있는 쓰레드가 종료되면 순차적으로 처리 , 쓰레드와 큐가 모두 꽉차게 되면
										// Exception이 발생
		executor.setThreadNamePrefix("[thread] taskExecutor100-");
		executor.initialize();
		return executor;
	}

	@Bean(name = "taskExecutor500")
	public Executor taskExecutor500() {
		log.info("taskExecutor500. " + Thread.currentThread().getName());
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(500);
		executor.setMaxPoolSize(500);
		executor.setQueueCapacity(0);// 쓰레드가 모두 처리중일때 추가 요청이 들어오면 Exception을 발생
		executor.setThreadNamePrefix("[thread] taskExecutor500-");
		executor.initialize();
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new CustomAsyncExceptionHandler();
	}

}
