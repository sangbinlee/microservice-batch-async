package com.topas.microservicebatchasync.control;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topas.microservicebatchasync.service.AsyncService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/async")
public class AsyncController {
//    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);
//	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private AsyncService asyncService;

	/**
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/")
	public String greeting() throws Exception {
//        return "Hello async";
        Future<Long> asyncResult4 = asyncService.callAsync(4);
        log.info("result 4 took: " + asyncResult4.get());
        log.info("result 4 took: " + asyncResult4.get());
        log.info("result 4 took: " + asyncResult4.get());
        log.info("result 4 took: " + asyncResult4.get());
        log.info("result 4 took: " + asyncResult4.get());
		
		return asyncService.greet();
	}

	/**
	 * 설정 100
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/100")
	public String taskExecutor100() throws Exception {

		log.info("Invoking an asynchronous method. " + Thread.currentThread().getName());

		Future<String> future;
		CompletableFuture<Boolean> future2;

		// Start the clock
		long start = System.currentTimeMillis();
		log.info("@Async call .........--> " + "[start]" + start);
		for (int i = 1; i <= 501; i++) {
			log.info("taskExecutor100 쓰레드 번호=" + i);
			future2 = asyncService.taskExecutor100();
		}
		log.info("@Async call .........--> " + "[end]");

		
		
		// Wait until they are all done
//        CompletableFuture.allOf(page1,page2,page3).join();

		// Print results, including elapsed time
		log.info("Elapsed time: " + (System.currentTimeMillis() - start));

		log.info("@Async 결과 .........--> " + "[결과 받을 때 까지 대기 ......]");
		log.info("@Async 결과 .........--> " + "[결과 받을 때 까지 대기 ......]");
		log.info("@Async 결과 .........--> " + "[결과 받을 때 까지 대기 ......]");
		log.info("@Async 결과 .........--> " + "[결과 받을 때 까지 대기 ......]");
		log.info("@Async 결과 .........--> " + "[start]");
//		log.info("--> " + page1.get());
//		log.info("--> " + page2.get());
//		log.info("--> " + page3.get());
		log.info("@Async 결과 .........--> " + "[end]");

		String str = "taskExecutor100";
		log.info(str + " end...");
		return str;
	}

	/**
	 * 설정 500
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/500")
	public String taskExecutor500() throws Exception {
		for (int i = 1; i <= 501; i++) {
			log.info("taskExecutor500 쓰레드 번호=" + i);
			Future<String> future = asyncService.taskExecutor500();
		}
		String str = "taskExecutor500";
		log.info(str + " end...");
		return str;
	}

	@GetMapping("/async")
	public String async() throws Exception {

//		final String arr[] = new String[] { 
//				"PivotalSoftware"
//				, "CloudFoundry"
//				, "Spring-Projects"
//				
//				, "PivotalSoftware" 
//				, "CloudFoundry"
//				, "Spring-Projects"
//				
//		};
//		

		log.info("" + " [ scheduled task - 묶음 (  )       ]");
//		log.info(""+"");
		log.info("" + "Q 조회 API 호출 로그 - [REQ]"); // aop 전처리
		log.info("" + "Q 조회 API 호출");
		log.info("" + "Q 조회 API 호출 로그 - [RES] - 성공, 실패, 리턴값 "); // aop 후처리

		log.info("" + "호출 결과 목록 존재시 - Q 관리 테이블 저장 - 상태는 BEFORE [변경전] ");

		log.info("" + "Q 삭제 API 호출 로그 - [REQ]"); // aop 전처리
		log.info("" + "Q 삭제 API 호출");
		log.info("" + "Q 삭제 API 호출 로그 - [RES] - 성공, 실패, 리턴값 "); // aop 후처리

		final List<String> initialList = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("PivotalSoftware");
				add("CloudFoundry");
				add("Spring-Projects");
				add("PivotalSoftware");
				add("CloudFoundry");
				add("Spring-Projects");
			}
		};
//
//	       // Elements of the array are appended at the end
//	       Collections.addAll(initialList, arr);

		for (int i = 1; i <= 501; i++) {
			log.info(" @Async 쓰레드 번호= " + i);
			for (String input : initialList) {
				asyncService.onAsync(input);
			}
		}

		String str = "비동기 Async!!";
		log.info(str);
		log.info("");
		return str;
	}

//	@GetMapping("/sync")
//	public String goSync() {
//		service.onSync();
//		String str = "Hello Spring Boot Sync!!";
//		log.info(str);
//		log.info("");
//		return str;
//	}
}
