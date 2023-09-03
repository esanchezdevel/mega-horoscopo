package com.mega.horoscopo.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mega.horoscopo.app.dto.PaypalCaptureOrderResponseDTO;
import com.mega.horoscopo.domain.model.entity.Order;
import com.mega.horoscopo.domain.model.repository.OrderRepository;
import com.mega.horoscopo.domain.service.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void storeOrder(String requestId, String horoscopeSign, PaypalCaptureOrderResponseDTO captureOrderResponse) {
		Order order = new Order();

		order.setHoroscopeSign(horoscopeSign);
		order.setOrderId(captureOrderResponse.getId());
		order.setPayerId(captureOrderResponse.getPayer().getPayerId());
		order.setTotalAmount(Double.parseDouble(captureOrderResponse.getPurchaseUnits().get(0).getPayments().getCaptures().get(0).getSellerReceivableBreakdown().getGrossAmount().getValue()));
		order.setNetAmount(Double.parseDouble(captureOrderResponse.getPurchaseUnits().get(0).getPayments().getCaptures().get(0).getSellerReceivableBreakdown().getNetAmount().getValue()));
		order.setPaypalFee(Double.parseDouble(captureOrderResponse.getPurchaseUnits().get(0).getPayments().getCaptures().get(0).getSellerReceivableBreakdown().getPaypalFee().getValue()));
		order.setCurrency(captureOrderResponse.getPurchaseUnits().get(0).getPayments().getCaptures().get(0).getSellerReceivableBreakdown().getGrossAmount().getCurrencyCode());
		order.setPurchaseReferenceId(captureOrderResponse.getPurchaseUnits().get(0).getReferenceId());
		order.setRequestId(requestId);
		order.setStatus(captureOrderResponse.getStatus());
		order.setUserAccountId(captureOrderResponse.getPaymentSource().getPaypal().getAccountId());
		order.setUserEmail(captureOrderResponse.getPayer().getEmailAddress());
		order.setUserName(captureOrderResponse.getPayer().getName().getGivenName());
		order.setUserSurname(captureOrderResponse.getPayer().getName().getSurname());
		order.setCountryCode(captureOrderResponse.getPayer().getAddress().getCountryCode());
		
		captureOrderResponse.getPurchaseUnits().get(0).getPayments().getCaptures().get(0).getLinks().forEach(link -> {
			if ("refund".equals(link.getRel())) {
				order.setRefundUrl(link.getHref());
			}
		});
		
		orderRepository.save(order);
	}
}
