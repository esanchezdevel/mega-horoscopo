package com.mega.horoscopo.domain.service.interfaces;

import com.mega.horoscopo.app.dto.PaypalCaptureOrderResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderRequestDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;
import com.mega.horoscopo.domain.model.entity.Transaction;

public interface TransactionService {

	/**
	 * Store a transaction in database
	 * 
	 * @param transaction The transaction to be saved
	 */
	void storeTransaction(Transaction transaction);

	/**
	 * Create a Transaction object to store the data related to the Paypal request
	 * used to create an order
	 * 
	 * @param requestId The unique id sent in the request headers to Paypal
	 * @param request   The request sent to Paypal
	 * @param response  The response received from Paypal
	 * @return The Transaction object with all the data
	 */
	Transaction createCreateOrderTransaction(String requestId, PaypalCreateOrderRequestDTO request,
			PaypalCreateOrderResponseDTO response);

	/**
	 * Create a Transaction object to store the data related to the Paypal request
	 * used to capture an order
	 * 
	 * @param requestId The unique id sent in the request headers to Paypal
	 * @param orderId   The id of the order that is captured
	 * @param response  The response received from Paypal
	 * @return The Transaction object with all the data
	 */
	Transaction createCaptureOrderTransaction(String requestId, String orderId, PaypalCaptureOrderResponseDTO response);
}
