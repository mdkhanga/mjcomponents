package com.mj.poker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokerApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(PokerApplication.class, args);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
