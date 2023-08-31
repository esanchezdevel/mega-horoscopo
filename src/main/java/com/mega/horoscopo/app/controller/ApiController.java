package com.mega.horoscopo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mega.horoscopo.app.dto.PaypalCaptureOrderRequestDTO;
import com.mega.horoscopo.app.dto.PaypalCaptureOrderResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;
import com.mega.horoscopo.domain.service.interfaces.PaypalService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

	@Autowired
	private PaypalService paypalService;
	
	@PostMapping("/paypal/order/create")
	public ResponseEntity<?> createPaypalOrder() throws JsonProcessingException {
		
		PaypalCreateOrderResponseDTO createOrderResponse = paypalService.createOrder();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = mapper.writeValueAsString(createOrderResponse);
		return ResponseEntity.ok().body(jsonResponse);
	}
	
	@PostMapping("/paypal/order/capture")
	public ResponseEntity<?> capturePaypalOrder(@RequestBody PaypalCaptureOrderRequestDTO request, HttpServletResponse response) throws JsonProcessingException {
		
		PaypalCaptureOrderResponseDTO captureOrderResponse = paypalService.captureOrder(request);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = mapper.writeValueAsString(captureOrderResponse);
		
		Cookie cookie = new Cookie("sign-token", "test-token");
		cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		
		return ResponseEntity.ok().body(jsonResponse);
	}
}
