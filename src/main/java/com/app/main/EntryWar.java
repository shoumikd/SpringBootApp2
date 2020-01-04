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
@ComponentScan({ "com.app.controller", "com.app.service", "com.app.job" })
@EnableJpaRepositories("com.app.repository")
@EntityScan("com.app.model")
@EnableScheduling
public class EntryWar extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EntryWar.class, args);
	}

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EntryWar.class);
	}

}
