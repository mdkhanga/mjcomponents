package com.mj.poker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokerApplication {

	static Logger LOGGER = LoggerFactory.getLogger(PokerApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(PokerApplication.class, args);
		} catch (Exception e) {
			// System.out.println(e);
			LOGGER.error("Error starting Poker:", e);
		}
	}

}
