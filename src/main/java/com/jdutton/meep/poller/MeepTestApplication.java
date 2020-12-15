package com.jdutton.meep.poller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableCircuitBreaker
@SpringBootApplication
@EnableScheduling
public class MeepTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeepTestApplication.class, args);
	}

}
