package com.topas.microservicebatchasync.controller;

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
public class MybatisController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@Resource
	public OracleMapper oracleMapper;
 
    

	@GetMapping("/select")
	public List<Map<String, Object>> select(Map<String, Object> model) {
		Map<String, Object> map = new HashMap<>();
		return oracleMapper.select(map);
	}

}
