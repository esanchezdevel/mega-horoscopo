package com.mega.horoscopo.domain.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mega.horoscopo.app.dto.PaypalAccessTokenResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderRequestDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;
import com.mega.horoscopo.domain.service.interfaces.PaypalService;
import com.mega.horoscopo.infrastructure.configuration.PaypalConfiguration;
import com.mega.horoscopo.infrastructure.http.PaypalClient;

public class PaypalServiceImpl implements PaypalService {

	private static final Logger logger = LogManager.getLogger(PaypalServiceImpl.class);
	
	@Autowired
	private PaypalClient paypalClient;
	
	@Autowired
	private PaypalConfiguration paypalConfiguration;
	
	@Override
	public String getAccessToken() {
		String auth = paypalConfiguration.getClientId() + ":" + paypalConfiguration.getClientSecret();

		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
		String credentials = "Basic " + new String(encodedAuth);
		
		PaypalAccessTokenResponseDTO accessToken = paypalClient.getAccessToken(credentials, "grant_type=client_credentials");
		
		return accessToken.getAccessToken();
	}
	
	@Override
	public String createOrder() {
		
		String accessToken = getAccessToken();
		
		PaypalCreateOrderRequestDTO createOrderRequest = new PaypalCreateOrderRequestDTO();
		//TODO fill the DTO
		String requestId = UUID.randomUUID().toString();
		PaypalCreateOrderResponseDTO createOrderResponse = paypalClient.createOrder(requestId, "Bearer " + accessToken, createOrderRequest);
		
		return createOrderResponse.getId();
	}
	
	@Override
	public String completeOrder() {
		// TODO Auto-generated method stub
		return null;
	}
}
