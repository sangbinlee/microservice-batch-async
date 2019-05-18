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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class ScheduledTimerStopWatch {

//	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private final AtomicLong counter = new AtomicLong();
	private AtomicInteger loopCounter = new AtomicInteger();

	@Autowired
	private StopWatch watch;

	@PostConstruct
	public void init() {
		watch.start();
	}

//	@Scheduled(fixedRate = 5000) // 2000 = 2 seconds
//	@Scheduled(cron = "*/5 * * * * *") // 5초마다
//	@Scheduled(cron = "0/5 * * * * *") // 5초마다
//	@Scheduled(fixedDelayString = "5000")
	public void scheduledTimerStopWatch() throws InterruptedException {
		watch.stop();
		log.info(watch.prettyPrint());
		String taskName = "task-";
//		taskName = taskName + String.valueOf(loopCounter.getAndIncrement());
		taskName = taskName + String.valueOf(counter.incrementAndGet());
		watch.start(taskName);
//		watch.stop();
//		log.info(watch.prettyPrint());
	}

	@Bean
	public StopWatch watch() {
		log.info("★★★★★ [scheduledTimerStopWatch]  watch =");
		return new StopWatch();
	}

}
