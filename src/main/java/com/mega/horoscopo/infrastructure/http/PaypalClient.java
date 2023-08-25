package com.mega.horoscopo.infrastructure.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mega.horoscopo.app.dto.PaypalAccessTokenResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderRequestDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;

import feign.Headers;

@FeignClient(value = "paypalClient", url = "${paypal.baseUrl}")
public interface PaypalClient {
	
	@PostMapping("/v1/oauth2/token")
	@Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json", "Accept-Language: es_US"})
	PaypalAccessTokenResponseDTO getAccessToken(@RequestHeader("authorization") String token, @RequestBody String grantType);

	@PostMapping("/v2/checkout/orders")
	@Headers({"Content-Type: application/json", "Accept: application/json"})
	PaypalCreateOrderResponseDTO createOrder(@RequestHeader("PayPal-Request-Id") String requestId, @RequestHeader("Authorization") String token, @RequestBody PaypalCreateOrderRequestDTO request);
}
