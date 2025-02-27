package com.project.Dashboard_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DashboardServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashboardServiceApplication.class, args);
        
        
    }
    @Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
}
