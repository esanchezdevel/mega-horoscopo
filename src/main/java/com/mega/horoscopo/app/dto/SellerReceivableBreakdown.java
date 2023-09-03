package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SellerReceivableBreakdown {

	@JsonProperty("gross_amount")
	private Amount grossAmount;
	
	@JsonProperty("net_amount")
	private Amount netAmount;
	
	@JsonProperty("paypal_fee")
	private Amount paypalFee;

	public Amount getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Amount grossAmount) {
		this.grossAmount = grossAmount;
	}

	public Amount getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Amount netAmount) {
		this.netAmount = netAmount;
	}

	public Amount getPaypalFee() {
		return paypalFee;
	}

	public void setPaypalFee(Amount paypalFee) {
		this.paypalFee = paypalFee;
	}

	@Override
	public String toString() {
		return "SellerReceivableBreakdown [grossAmount=" + grossAmount + ", netAmount=" + netAmount + ", paypalFee="
				+ paypalFee + "]";
	}
}
