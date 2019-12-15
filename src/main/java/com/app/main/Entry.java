package com.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({"com.app.controller","com.app.service","com.app.job"})
@EnableJpaRepositories("com.app.repository")
@EntityScan("com.app.model")
@EnableScheduling
//for war
public class Entry extends SpringBootServletInitializer {

//for JAR
//public class Entry{
	public static void main(String[] args) {
		SpringApplication.run(Entry.class, args);
	}

//for war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Entry.class);
	}

}
