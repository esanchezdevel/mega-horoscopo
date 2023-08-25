package com.mega.horoscopo.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaypalCreateOrderResponseDTO {

	private String id;
	
	private String status;
	
	@JsonProperty("payment_source")
	private PaymentSource paymentSource;
	
	private List<Link> links;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentSource getPaymentSource() {
		return paymentSource;
	}

	public void setPaymentSource(PaymentSource paymentSource) {
		this.paymentSource = paymentSource;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "PaypalCreateOrderResponseDTO [id=" + id + ", status=" + status + ", paymentSource=" + paymentSource
				+ ", links=" + links + "]";
	}
}
