package com.mega.horoscopo.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalCaptureOrderResponseDTO {

	private String id;
	
	private String status;
	
	@JsonProperty("payment_source")
	private PaymentSource paymentSource;
	
	@JsonProperty("purchase_units")
	private List<PurchaseUnit> purchaseUnits;
	
	private Payer payer;
	
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

	public List<PurchaseUnit> getPurchaseUnits() {
		return purchaseUnits;
	}

	public void setPurchaseUnits(List<PurchaseUnit> purchaseUnits) {
		this.purchaseUnits = purchaseUnits;
	}

	public Payer getPayer() {
		return payer;
	}

	public void setPayer(Payer payer) {
		this.payer = payer;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "PaypalCaptureOrderResponseDTO [id=" + id + ", status=" + status + ", paymentSource=" + paymentSource
				+ ", purchaseUnits=" + purchaseUnits + ", payer=" + payer + ", links=" + links + "]";
	}
}
