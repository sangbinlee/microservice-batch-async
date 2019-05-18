package com.topas.microservicebatchasync.control;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.topas.microservicebatchasync.mapper.oracle.OracleMapper;
import com.topas.microservicebatchasync.vo.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@Resource
	public OracleMapper oracleMapper;

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    

	@GetMapping("/select")
	public List<Map<String, Object>> select(Map<String, Object> model) {
		Map<String, Object> map = new HashMap<>();
		
		
		
		return oracleMapper.select(map);
	}

}
