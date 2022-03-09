package com.spring.springconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@SpringBootApplication
public class SpringConfigClientApplication {

	@Value("${appName:Config Server is not working. Please check...}")
	private String name;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}

	@GetMapping("/check/property")
	public String getName() {
		return "Hello Viewers, You are using Environemnt - " + this.name;
	}
}
