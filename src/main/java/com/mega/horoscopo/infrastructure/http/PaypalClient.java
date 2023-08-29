package com.mega.horoscopo.infrastructure.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mega.horoscopo.app.dto.PaypalAccessTokenResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCaptureOrderResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderRequestDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;

import feign.Headers;

@FeignClient(value = "paypalClient", url = "${paypal.baseUrl}")
public interface PaypalClient {
	
	@PostMapping(value = "/v1/oauth2/token")
	@Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: application/json", "Accept-Language: es_US"})
	PaypalAccessTokenResponseDTO getAccessToken(@RequestHeader("authorization") String token, @RequestBody String grantType);

	@PostMapping(value = "/v2/checkout/orders", consumes = "application/json", produces = "application/json")
	PaypalCreateOrderResponseDTO createOrder(@RequestHeader("PayPal-Request-Id") String requestId, @RequestHeader("Authorization") String token, @RequestBody PaypalCreateOrderRequestDTO request);
	
	@PostMapping(value = "/v2/checkout/orders/{orderId}/capture", consumes = "application/json", produces = "application/json")
	PaypalCaptureOrderResponseDTO captureOrder(@RequestHeader("PayPal-Request-Id") String requestId, @RequestHeader("Authorization") String token, @PathVariable("orderId") String orderId);
	
}
