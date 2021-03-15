package com.spring.database.database;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.database.jdbc.PersonJdbcDao;
import com.spring.database.database.jdbc.entity.Person;

//@SpringBootApplication
public class DatabaseJdbcApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All users -> {}", dao.findAll());
		log.info("Person by id: 1003 -> {}", dao.findById(10003));
		log.info("No. of rows deleted -> {}", dao.deleteById(10003));
		log.info("Insert rows -> {}", dao.insert(new Person(10003, "Ravi", "Bombay", new Date(0))));
	}

}
