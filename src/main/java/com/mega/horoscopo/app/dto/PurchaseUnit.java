package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseUnit {

	@JsonProperty("reference_id")
	private String referenceId;
	
	private Amount amount;

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
		return "PurchaseUnit [referenceId=" + referenceId + ", amount=" + amount + "]";
	}
}
