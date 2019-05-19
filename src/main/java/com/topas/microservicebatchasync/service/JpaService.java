package com.topas.microservicebatchasync.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topas.microservicebatchasync.jpa.oracle.domain.OracleQ;
import com.topas.microservicebatchasync.jpa.oracle.repo.OracleQRepository;
import com.topas.microservicebatchasync.jpa.postgres.domain.PostgresQ;
import com.topas.microservicebatchasync.jpa.postgres.repo.PostgresQRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JpaService {

    @Autowired
    private OracleQRepository oracleQRepository;
 
    @Autowired
    private PostgresQRepository postgresQRepository;
	
    public Iterable<OracleQ> getOracleQ() {
		return oracleQRepository.findAll();
	}

    public Iterable<PostgresQ> getPostgresQ() {
		return postgresQRepository.findAll();
	}
    
    
}