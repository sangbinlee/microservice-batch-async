package com.topas.microservicebatchasync.control;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.topas.microservicebatchasync.mapper.oracle.OracleMapper;

@Controller
public class OracleController {
	@Resource
	public OracleMapper oracleMapper;
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/select222")
	public String select222(Map<String, Object> model) {
		Map<String, Object> map = new HashMap<>();
		Object result = oracleMapper.select(map);
		model.put("time", new Date());
		model.put("message", this.message);
		return "select";
	}

}