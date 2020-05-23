package com.sapient.teamstanding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
//@EnableHystrix
public class TeamStandingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamStandingApplication.class, args);
	}
	
	@Bean
	ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
