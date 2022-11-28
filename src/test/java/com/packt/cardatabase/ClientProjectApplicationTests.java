package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import seanx63.clientproject.web.ProjectController;

@SpringBootTest
class ClientProjectApplicationTests {
	@Autowired
	private ProjectController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
