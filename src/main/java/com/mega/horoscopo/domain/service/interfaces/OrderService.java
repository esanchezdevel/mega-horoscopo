package com.mega.horoscopo.domain.service.interfaces;

import com.mega.horoscopo.app.dto.PaypalCaptureOrderResponseDTO;

public interface OrderService {

	/**
	 * Store in db the register of a new order with all the needed information
	 * 
	 * @param requestId            The unique request id used in the capture order
	 *                             request
	 * @param horoscopeSign        The content that the user wanted to see
	 * @param captureOrderResponse The response of the Capture Order request where
	 *                             we can find most of the data that we want to
	 *                             store.
	 */
	void storeOrder(String requestId, String horoscopeSign, PaypalCaptureOrderResponseDTO captureOrderResponse);
}
