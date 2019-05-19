package com.topas.microservicebatchasync.control;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topas.microservicebatchasync.jpa.oracle.domain.OracleQ;
import com.topas.microservicebatchasync.jpa.oracle.repo.OracleQRepository;
import com.topas.microservicebatchasync.jpa.postgres.domain.PostgresQ;
import com.topas.microservicebatchasync.jpa.postgres.repo.PostgresQRepository;
import com.topas.microservicebatchasync.mapper.oracle.OracleMapper;
import com.topas.microservicebatchasync.service.JpaService;

@RestController
public class JpaController {

	@Resource
	public OracleMapper oracleMapper;
 

    @Autowired
    private JpaService jpaService;


    @Autowired
    private PostgresQRepository postgresQRepository;
    
    @Autowired
    private OracleQRepository oracleQRepository;
    
    
    
	@GetMapping("/jpa/oracle/select")
	public Iterable<OracleQ> selectOracle(Map<String, Object> model) {
//		Map<String, Object> map = new HashMap<>();
		return jpaService.getOracleQ();
	}
	
	@GetMapping("/jpa/postgres/select")
	public Iterable<PostgresQ> selectPostgres(Map<String, Object> model) {
//		Map<String, Object> map = new HashMap<>();
		return jpaService.getPostgresQ();
	}

}
