package com.demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	@Bean()
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		System.out.println(ds.getPassword());
		return ds;
	}

	@Bean
	public Flyway getFlyway() {
	Flyway flyway = new DbMigration();
	flyway.setDataSource(getDataSource());
	flyway.setValidateOnMigrate(false);
	flyway.setLocations("classpath:/db/migration");
	return flyway;
	}
}
