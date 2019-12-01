package com.app.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReadData {
	
	@Scheduled(cron="0/20 * * * * ?")
	public void read() {
		System.out.println("ran at:"+ System.currentTimeMillis());
	}

}
