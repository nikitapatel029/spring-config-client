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

	@Value("${appEnvName:Config Server is not working. Please check...}")
	private String name;
	
	
	@Value("${name: Server is not working. Please check...}")
	private String defaultName;
	
	@Value("${springConfigClientName: Server is not working. Please check...}")
	private String springConfigClientName;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}

	@GetMapping("/check/property")
	public String getName() {
		return "Hello Viewers, <br/><br/> You are using Application <b>-" + this.name +"</b><br/><br/>default config-client application properties which is stored at config-client root level is - <b>"+ this.springConfigClientName+ " </b><br/><br/> And default application name which is stored at root level is - <b>"+ this.defaultName+"</b>";
	}
}

