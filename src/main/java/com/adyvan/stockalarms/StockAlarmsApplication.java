package com.adyvan.stockalarms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableScheduling
public class StockAlarmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockAlarmsApplication.class, args);
	}

}
