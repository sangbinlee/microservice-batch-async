package com.topas.microservicebatchasync.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class OracleConfig {

//	String currentThread = Thread.currentThread().getName();
//	log.info("★★★★★ [CorsConfig]  corsConfigurer =" + "[" + currentThread + "]");

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(ds);
		factory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/oracle/*_SQL.xml") // A
		);
		return factory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
}
