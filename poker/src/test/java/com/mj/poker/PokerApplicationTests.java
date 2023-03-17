package com.mj.poker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokerApplicationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	void contextLoads() {
	}

	@Test
	public void about() {
		ResponseEntity<String> response = template.getForEntity("/poker/about", String.class);
		assertThat(response.getBody()).isEqualTo("Poker for Quicken");
	}

}
