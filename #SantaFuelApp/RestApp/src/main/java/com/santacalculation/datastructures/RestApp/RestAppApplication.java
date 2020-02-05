package com.santacalculation.datastructures.RestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Called an annotation, a way to wire stuff up in the background
public class RestAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}
}
