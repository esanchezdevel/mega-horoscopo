package com.mega.horoscopo.domain.service.interfaces;

public interface PaypalService {

	String getAccessToken();
	
	String createOrder();
	
	String completeOrder();
}
