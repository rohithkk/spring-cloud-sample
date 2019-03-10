package com.kodakandla.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public void sayHello() throws InterruptedException {
		long timeToSleep = (long) (Math.random() * 1000);
		Thread.sleep(timeToSleep);
	}
}
