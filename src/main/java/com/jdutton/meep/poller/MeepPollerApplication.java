package com.jdutton.meep.poller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableCircuitBreaker
@SpringBootApplication
@EnableScheduling
public class MeepPollerApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(MeepPollerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MeepPollerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Starting resource service...");
	}

}
