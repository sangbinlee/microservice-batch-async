package com.topas.microservicebatchasync.mapper.oracle;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OracleMapper {
//	public List<Q> select(Q q);
	public List<Map<String, Object>> select(Map<String, Object> map);
	
	
	
}
