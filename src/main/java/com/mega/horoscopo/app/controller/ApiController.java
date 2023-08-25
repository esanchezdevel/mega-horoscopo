package com.mega.horoscopo.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

	@PostMapping("/paypal/order/create")
	public ResponseEntity<?> createPaypalOrder() {
		
		String orderId = "1";
		
		return ResponseEntity.ok().body("{\"orderId\": \"" + orderId + "\"}");
	}
}
