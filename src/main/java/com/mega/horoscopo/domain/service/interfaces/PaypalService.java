package com.mega.horoscopo.domain.service.interfaces;

import com.mega.horoscopo.app.dto.PaypalCaptureOrderResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;

public interface PaypalService {

	String getAccessToken();
	
	PaypalCreateOrderResponseDTO createOrder();
	
	PaypalCaptureOrderResponseDTO captureOrder(String orderId);
}
