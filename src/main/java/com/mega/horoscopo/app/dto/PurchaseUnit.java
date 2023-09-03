package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseUnit {

	private Amount amount;
	
	private Payment payments;
	
	@JsonProperty("reference_id")
	private String referenceId;

	public Payment getPayments() {
		return payments;
	}

	public void setPayments(Payment payments) {
		this.payments = payments;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PurchaseUnit [amount=" + amount + ", payments=" + payments + ", referenceId=" + referenceId + "]";
	}
}
