package com.topas.microservicebatchasync.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "qEntityManagerFactory", transactionManagerRef = "qTransactionManager", basePackages = {
		"com.topas.microservice.batch.async.q.repo" })
public class QConfiguration {

	@Bean(name = "qDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource qDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "qEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("qDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.topas.microservice.batch.async.q.data")
				.persistenceUnit("db2").build();
	}

	@Bean(name = "qTransactionManager")
	public PlatformTransactionManager qTransactionManager(
			@Qualifier("qEntityManagerFactory") EntityManagerFactory qEntityManagerFactory) {
		return new JpaTransactionManager(qEntityManagerFactory);
	}

}
