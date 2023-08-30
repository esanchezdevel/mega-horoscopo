package com.mega.horoscopo.domain.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mega.horoscopo.app.dto.PaypalCaptureOrderResponseDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderRequestDTO;
import com.mega.horoscopo.app.dto.PaypalCreateOrderResponseDTO;
import com.mega.horoscopo.domain.model.entity.Transaction;
import com.mega.horoscopo.domain.model.repository.TransactionRepository;
import com.mega.horoscopo.domain.service.interfaces.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LogManager.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void storeTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}
	
	@Override
	public Transaction createCreateOrderTransaction(String requestId, PaypalCreateOrderRequestDTO request,
			PaypalCreateOrderResponseDTO response) {
		
		Transaction transaction = new Transaction();
		transaction.setRequestId(requestId);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonRequest = mapper.writeValueAsString(request);
			transaction.setRequest(jsonRequest);
		} catch (JsonProcessingException e) {
			logger.error("Error parsing create order request " + request);
			transaction.setRequest(request.toString());
		}

		try {
			String jsonResponse = mapper.writeValueAsString(response);
			transaction.setResponse(jsonResponse);
		} catch (JsonProcessingException e) {
			logger.error("Error parsing create order response " + response);
			transaction.setResponse(response.toString());
		}
		
		
		transaction.setRequestType("POST");
		transaction.setUrl("/v2/checkout/orders");
		
		return transaction;
	}
	
	@Override
	public Transaction createCaptureOrderTransaction(String requestId, String orderId,
			PaypalCaptureOrderResponseDTO response) {
		
		Transaction transaction = new Transaction();
		transaction.setRequestId(requestId);
		transaction.setRequest("orderId = " + orderId);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonResponse = mapper.writeValueAsString(response);
			transaction.setResponse(jsonResponse);
		} catch (JsonProcessingException e) {
			logger.error("Error parsing capture order response " + response);
			transaction.setResponse(response.toString());
		}
		
		transaction.setRequestType("POST");
		transaction.setUrl(String.format("/v2/checkout/orders/%s/capture", orderId));
		
		return transaction;
	}
}
