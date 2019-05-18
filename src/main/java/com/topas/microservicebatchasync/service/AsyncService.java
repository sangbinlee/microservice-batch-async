package com.topas.microservicebatchasync.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.topas.microservicebatchasync.vo.PnrUpdate_Service_RS;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService {

//    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private final RestTemplate restTemplate;

	public AsyncService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

//	@Async
//	public void onAsync() {
//		// TODO Auto-generated method stub
//		
//	}
//	public void onSync() {
//		// TODO Auto-generated method stub
//
//	}

	public String greet() {
		return "Hello async";
	}

	@Async
	public Future<Long> callAsync(int taskCall) throws InterruptedException {

		long start = System.nanoTime();
		log.info("task " + taskCall + " starting");
		log.info("task " + taskCall + " starting");
		log.info("task " + taskCall + " starting");
		log.info("task " + taskCall + " starting");

		Thread.sleep(5000);

		long duration = (System.nanoTime() - start) / 1000000;

		log.info("task " + taskCall + "completed in " + duration);
		log.info("task " + taskCall + "completed in " + duration);
		log.info("task " + taskCall + "completed in " + duration);
		log.info("task " + taskCall + "completed in " + duration);

//        return new AsyncResult<Long>(stopwatch.elapsed(TimeUnit.MILLISECONDS));
		return new AsyncResult<Long>((long) 999);
	}

	@Async
	public CompletableFuture<PnrUpdate_Service_RS> onAsync(String user) throws InterruptedException {
		log.info("[ input ] Execute method asynchronously " + Thread.currentThread().getName());
		log.info("[ input ] Looking up " + user);

		String url = String.format("https://api.github.com/users/%s", user);
		PnrUpdate_Service_RS results = restTemplate.getForObject(url, PnrUpdate_Service_RS.class);
		// Artificial delay of 1s for demonstration purposes
		Thread.sleep(1000L);
		return CompletableFuture.completedFuture(results);
	}

	@Async("taskExecutor100")
	public CompletableFuture<Boolean> taskExecutor100() throws Exception {
		String currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "★★★ [AsyncService taskExecutor100 시작 -  time = {}",
				dateFormat.format(new Date()));
		
		Thread.sleep(5000L);

		Boolean results = true;

//        String url = String.format("https://api.github.com/users/%s", user);
//        User results = restTemplate.getForObject(url, User.class);

		currentThread = Thread.currentThread().getName();
		log.info("[" + currentThread + "]" + "★★★ [AsyncService taskExecutor100 끝 -  time = {}",
				dateFormat.format(new Date()));
		return CompletableFuture.completedFuture(results);
	}

	@Async("taskExecutor500")
	public Future<String> taskExecutor500() throws Exception {
		log.info("[ taskExecutor500 ] called " + 500);
		log.info("Execute method asynchronously. " + Thread.currentThread().getName());
		Thread.sleep(5000L);
		return new AsyncResult<String>("SUCCESS");
	}

}