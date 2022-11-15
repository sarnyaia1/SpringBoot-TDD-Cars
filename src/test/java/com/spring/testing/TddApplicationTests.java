package com.spring.testing;

import com.spring.testing.controller.HomeController;
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
	private HomeController homeController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	//sanity check for context load
	public void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}

	@Test
	public void homeControllerShouldReturnMessage() throws Exception {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/home", String.class))
				.contains("Hello, World");
	}

	@Test
	public void greetingControllerShouldReturnMessage() throws Exception {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class))
				.contains("Hello, World");
	}


}
