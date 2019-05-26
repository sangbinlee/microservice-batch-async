package com.topas.microservicebatchasync.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresqlEntityManagerFactory"
, transactionManagerRef = "postgresqlTransactionManager"
, basePackages = {
		"com.topas.microservicebatchasync.jpa.postgres.repo" })
public class PostgresConfig {
	@Bean(name = "postgresqlDataSource")
	@ConfigurationProperties(prefix = "postgresql.spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresqlDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.topas.microservicebatchasync.jpa.postgres.domain").persistenceUnit("db2")
				.build();
	}

	@Bean(name = "postgresqlTransactionManager")
	public PlatformTransactionManager postgresqlTransactionManager(
			@Qualifier("postgresqlEntityManagerFactory") EntityManagerFactory postgresqlEntityManagerFactory) {
		return new JpaTransactionManager(postgresqlEntityManagerFactory);
	}

}
