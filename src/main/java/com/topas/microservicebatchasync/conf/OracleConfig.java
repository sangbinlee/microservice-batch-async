package com.topas.microservicebatchasync.conf;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory"
, transactionManagerRef = "oracleTransactionManager"
, basePackages = {
		"com.topas.microservicebatchasync.jpa.oracle.repo" })
//@ComponentScan("com.topas.microservicebatchasync.jpa.oracle.domain")
//@EntityScan("com.topas.microservicebatchasync.jpa.oracle.domain")
public class OracleConfig {

	@Primary
	@Bean(name = "oracleDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("oracleDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.topas.microservicebatchasync.jpa.oracle.domain")
				.persistenceUnit("db1")
				.build();
	}
	
	@Primary
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager oracleTransactionManager(
			@Qualifier("oracleEntityManagerFactory") EntityManagerFactory oracleEntityManagerFactory) {
		return new JpaTransactionManager(oracleEntityManagerFactory);
	}

	
	/**
	 * mybatis set 1
	 * @param ds
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(ds);
		factory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/oracle/*_SQL.xml") // A
		);
		return factory.getObject();
	}

	/**
	 * mybatis set 2
	 * @param factory
	 * @return
	 */
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
}
