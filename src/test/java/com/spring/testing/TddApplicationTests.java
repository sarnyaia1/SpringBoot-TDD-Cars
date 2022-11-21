package com.spring.testing;

import com.spring.testing.controller.FriendController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TddApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private FriendController friendController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	//sanity check for context load
	public void contextLoads() {
		assertThat(friendController).isNotNull();
	}

	@Test
	public void homeControllerShouldReturnMessage() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/friend", String.class))
				.contains("Hello, my Friend!!");
	}

	@Test
	public void greetingControllerShouldReturnMessage() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class))
				.contains("Hello, World");
	}


}
