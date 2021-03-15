package com.spring.database.database;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.database.jpa.PersonJpaRepository;
import com.spring.database.database.jpa.entity.Person;
import com.spring.database.database.spring.jpa.PersonSpringJpaRepository;

@SpringBootApplication
public class DatabaseSpringJpaApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringJpaRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All users -> {}", repository.findAll());
		log.info("Person by id: 1003 -> {}", repository.findById(10003));
		//log.info("No. of rows deleted -> {}", dao.deleteById(10003));
		log.info("Insert rows -> {}", repository.save(new Person(10003, "Ravi", "Bombay", new Date(0))));
		log.info("Insert rows -> {}", repository.save(new Person("Updated Ravi", "Bombay", new Date(0))));
		repository.deleteById(10003);
		//log.info("");

	}

}
