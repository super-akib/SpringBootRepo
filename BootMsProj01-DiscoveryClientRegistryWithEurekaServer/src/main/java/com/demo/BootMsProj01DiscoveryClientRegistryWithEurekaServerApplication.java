package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj01DiscoveryClientRegistryWithEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj01DiscoveryClientRegistryWithEurekaServerApplication.class, args);
	}

}
