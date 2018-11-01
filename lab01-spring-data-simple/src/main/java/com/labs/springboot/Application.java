package com.labs.springboot;

import com.labs.springboot.entity.Customer;
import com.labs.springboot.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {// save a couple of customers
      repository.save(new Customer("Jack", "Bauer"));
      repository.save(new Customer("Chloe", "O'Brian"));
      repository.save(new Customer("Kim", "Bauer"));
      repository.save(new Customer("David", "Palmer"));
      repository.save(new Customer("Michelle", "Dessler"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("--------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
      }

      // fetch customer by Id
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");

      repository.findById(1L)
          .ifPresent(customer -> log.info(customer.toString()));

      // fetch customer by Id
      log.info("Customer found with findAllByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findAllByLastName("Bauer")
          .forEach(customer -> log.info(customer.toString()));
    };
  }
}
