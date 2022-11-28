package seanx63.clientproject;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import seanx63.clientproject.domain.Client;
import seanx63.clientproject.domain.ClientRepository;
import seanx63.clientproject.domain.Project;
import seanx63.clientproject.domain.ProjectRespository;
import seanx63.clientproject.domain.User;
import seanx63.clientproject.domain.UserRepository;

@SpringBootApplication
public class ClientProjectApplication implements CommandLineRunner {	
	private static final Logger logger = 
			LoggerFactory.getLogger(ClientProjectApplication.class);

	@Autowired
	private ProjectRespository repository;

	@Autowired
	private ClientRepository orepository;

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(ClientProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add owner objects and save these to db 
		Client client1 = new Client("John" , "Johnson");
		Client client2 = new  Client("Mary" , "Robinson");
		orepository.saveAll(Arrays.asList(client1, client2));

		// Add car object and link to owners and save these to db
		Project proj1 = new Project("First Project", "Description of first project", client1);
		Project proj2 = new Project("Second Project", "Description of second project", client2);
		Project proj3 = new Project("Third Project", "Description of third project", client2);
		repository.saveAll(Arrays.asList(proj1, proj2, proj3));

		for (Project project : repository.findAll()) {
			logger.info(project.getName()+": "+project.getDescription());
		}

		urepository.save(new User("user", 
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		urepository.save(new User("admin", 
				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}
}
