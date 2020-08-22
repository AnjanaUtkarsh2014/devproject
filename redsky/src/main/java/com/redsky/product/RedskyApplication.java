package com.redsky.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.ext.controller")
public class RedskyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedskyApplication.class, args);
	}

}
