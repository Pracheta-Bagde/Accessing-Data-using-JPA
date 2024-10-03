package com.example.accessingDataJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return (args) -> {
			//save few customers
			repository.save(new Customer("Rudra", "Rawal"));
			repository.save(new Customer("Shourya", "Rajput"));
			repository.save(new Customer("Tara","Rawal"));


			//fetch all customers
			log.info("Customers found with findAll():");
			log.info("--------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch by id
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("-----------------------------------");
			log.info(customer.toString());
			log.info("");

			//fetch by last name
			log.info("Customer found with findByLastName('Rawal'):");
			log.info("----------------------------------------------");
			repository.findByLastName("Rawal").forEach(Rawal -> {
				log.info(Rawal.toString());
			});
			log.info("");
		};
	}
}
