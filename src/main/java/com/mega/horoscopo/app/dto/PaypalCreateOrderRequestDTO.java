package com.mega.horoscopo.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalCreateOrderRequestDTO {

	private String intent;
	
	@JsonProperty("purchase_units")
	private List<PurchaseUnit> purchaseUnits;
	
	@JsonProperty("payment_source")
	private PaymentSource paymentSource;

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public List<PurchaseUnit> getPurchaseUnits() {
		return purchaseUnits;
	}

	public void setPurchaseUnits(List<PurchaseUnit> purchaseUnits) {
		this.purchaseUnits = purchaseUnits;
	}

	public PaymentSource getPaymentSource() {
		return paymentSource;
	}

	public void setPaymentSource(PaymentSource paymentSource) {
		this.paymentSource = paymentSource;
	}

	@Override
	public String toString() {
		return "PaypalCreateOrderRequestDTO [intent=" + intent + ", purchaseUnits=" + purchaseUnits + ", paymentSource="
				+ paymentSource + "]";
	}
}
