package com.msansar.wordmemorization;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class WordmemorizationApplication {
	public static void main(String[] args) {
		SpringApplication.run(WordmemorizationApplication.class, args);
	}

}