package com.heavyduty.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ServicesApplication.class, args);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
