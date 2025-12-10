package com.tcs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FirstrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstrestApplication.class, args);
	}

}
