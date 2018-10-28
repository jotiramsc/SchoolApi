package com.sbz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

	@Scheduled(fixedRate = 1000000)
	public void create() {
		System.out.println("CURRENT TIME: "+System.currentTimeMillis());
	}
}