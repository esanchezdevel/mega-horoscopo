package com.mega.horoscopo.domain.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mega.horoscopo.app.dto.Amount;
import com.mega.horoscopo.app.dto.ExperienceContext;
import com.mega.horoscopo.app.dto.PaymentSource;
import com.mega.horoscopo.app.dto.Paypal;
import com.mega.horoscopo.app.dto.PaypalAccessTokenResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderRequestDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;
import com.mega.horoscopo.app.dto.PurchaseUnit;
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
		
		Amount amount = new Amount();
		amount.setValue("1");
		amount.setCurrencyCode("EUR");
		
		List<PurchaseUnit> purchaseUnits = new ArrayList<>();
		PurchaseUnit purchaseUnit = new PurchaseUnit();
		purchaseUnit.setAmount(amount);
		purchaseUnit.setReferenceId(UUID.randomUUID().toString());
		
		ExperienceContext experienceContext = new ExperienceContext();
		experienceContext.setPaymentMethodPreference("IMMEDIATE_PAYMENT_REQUIRED");
		experienceContext.setBrandName("MEGA-HOROSCOPO");
		experienceContext.setLocale("en-US");
		experienceContext.setLandingPage("LOGIN");
		experienceContext.setShippingPreference("SET_PROVIDED_ADDRESS");
		experienceContext.setUserAction("PAY_NOW");
		experienceContext.setReturnUrl("https://example.com/returnUrl");
		experienceContext.setCancelUrl("https://example.com/cancelUrl");
		
		Paypal paypal = new Paypal();
		paypal.setExperienceContext(experienceContext);
		
		PaymentSource paymentSource = new PaymentSource();
		paymentSource.setPaypal(paypal);
		
		createOrderRequest.setIntent("CAPTURE");
		createOrderRequest.setPurchaseUnits(purchaseUnits);
		createOrderRequest.setPaymentSource(paymentSource);
		
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
