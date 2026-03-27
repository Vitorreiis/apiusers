package com.vitorreis.apiusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApiusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiusersApplication.class, args);
	}

}
