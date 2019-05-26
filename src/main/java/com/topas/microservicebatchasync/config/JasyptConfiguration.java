package com.topas.microservicebatchasync.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("encrypted.properties")
public class JasyptConfiguration {

//	@Bean
//	public static EnvironmentStringPBEConfig environmentVariablesConfiguration() {
//		EnvironmentStringPBEConfig environmentVariablesConfiguration = new EnvironmentStringPBEConfig();
//		environmentVariablesConfiguration.setAlgorithm("PBEWITHMD5ANDDES");
//		// environmentVariablesConfiguration.setPasswordEnvName("CAS_PBE_PASSWORD");
//		// super.setPassword(System.getenv(passwordEnvName));
//		environmentVariablesConfiguration.setPassword("topas_pw_key_is_id_ASYNC400");
//		return environmentVariablesConfiguration;
//	}
//
//	@Bean
//	public static StringEncryptor configurationEncryptor() {
//		StandardPBEStringEncryptor configurationEncryptor = new StandardPBEStringEncryptor();
//		configurationEncryptor.setConfig(environmentVariablesConfiguration());
//		return configurationEncryptor;
//	}
//
//	@Bean
//	public static PropertyPlaceholderConfigurer propertyConfigurer() {
//		EncryptablePropertyPlaceholderConfigurer propertyConfigurer = new EncryptablePropertyPlaceholderConfigurer(
//				configurationEncryptor());
//		propertyConfigurer.setLocation(new ClassPathResource("database.properties"));
//		// propertyConfigurer.setLocation(resource);
//		return propertyConfigurer;
//	}
//
////	spring.datasource.password=ENC
//
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}

}
