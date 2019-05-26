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
@EnableJpaRepositories(entityManagerFactoryRef = "h2EntityManagerFactory"
, transactionManagerRef = "h2TransactionManager"
, basePackages = {
		"com.topas.microservicebatchasync.jpa.h2.repo" })
public class H2Config {
	@Bean(name = "h2DataSource")
	@ConfigurationProperties(prefix = "h2.spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "h2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("h2DataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.topas.microservicebatchasync.jpa.h2.domain")
				.persistenceUnit("h2")
				.build();
	}

	@Bean(name = "h2TransactionManager")
	public PlatformTransactionManager h2TransactionManager(
			@Qualifier("h2EntityManagerFactory") EntityManagerFactory h2EntityManagerFactory) {
		return new JpaTransactionManager(h2EntityManagerFactory);
	}

}
