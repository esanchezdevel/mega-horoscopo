package com.mega.horoscopo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MegaHoroscopoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegaHoroscopoApplication.class, args);
	}
}
