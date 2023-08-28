package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSource {

	private Paypal paypal;

	public Paypal getPaypal() {
		return paypal;
	}

	public void setPaypal(Paypal paypal) {
		this.paypal = paypal;
	}

	@Override
	public String toString() {
		return "PaymentSource [paypal=" + paypal + "]";
	}
}
