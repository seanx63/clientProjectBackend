package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import seanx63.clientproject.domain.Client;
import seanx63.clientproject.domain.ClientRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	@Autowired
	private ClientRepository repository;
	
	@Test
	void saveOwner() {
		repository.save(new Client("Lucy", "Smith"));
		assertThat(repository.findByFirstname("Lucy").isPresent()).isTrue();
	}
	
	@Test
	void deleteOwners() {
		repository.save(new Client("Lisa", "Morrison"));
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
	}
	
}
