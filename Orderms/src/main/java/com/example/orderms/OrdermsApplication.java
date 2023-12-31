package com.example.orderms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrdermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermsApplication.class, args);
	}

}
