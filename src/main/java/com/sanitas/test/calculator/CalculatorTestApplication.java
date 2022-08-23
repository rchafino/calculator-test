package com.sanitas.test.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sanitas.test.calculator")
public class CalculatorTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorTestApplication.class, args);
	}

}