package com.mj.poker;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

	@Test
	public void inValidIsStraight() throws Exception{

		JSONObject card1 = new JSONObject()
				.put("value",8)
				.put("type","CLUBS");

		JSONArray body = new JSONArray().put(card1);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(body.toString(), headers);

		ResponseEntity<String> response = template.postForEntity("/poker/isstraight",entity, String.class);
		assertThat(response.getBody()).isEqualTo("false");

	}

	@Test
	public void ValidIsStraight() throws Exception{

		JSONObject card1 = new JSONObject()
				.put("value",5)
				.put("type","CLUBS");

		JSONObject card2 = new JSONObject()
				.put("value",8)
				.put("type","HEARTS");

		JSONObject card3 = new JSONObject()
				.put("value",6)
				.put("type","DIAMONDS");

		JSONObject card4 = new JSONObject()
				.put("value",11)
				.put("type","SPADES");

		JSONObject card5 = new JSONObject()
				.put("value",4)
				.put("type","CLUBS");

		JSONObject card6 = new JSONObject()
				.put("value",13)
				.put("type","HEARTS");

		JSONObject card7 = new JSONObject()
				.put("value",7)
				.put("type","DIAMONDS");


		JSONArray body = new JSONArray()
				.put(card1)
				.put(card2)
				.put(card3)
				.put(card4)
				.put(card5)
				.put(card6)
				.put(card7);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(body.toString(), headers);

		ResponseEntity<String> response = template.postForEntity("/poker/isstraight",entity, String.class);
		assertThat(response.getBody()).isEqualTo("true");

	}


}
