package com.mega.horoscopo.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Capture {

	private Amount amount;
	
	@JsonProperty("final_capture;")
	private boolean finalCapture;
	
	private String id;
	
	@JsonProperty("create_time")
	private String createTime;
	
	private List<Link> links;
	
	@JsonProperty("seller_receivable_breakdown")
	private SellerReceivableBreakdown sellerReceivableBreakdown;
	
	private String status;

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public boolean isFinalCapture() {
		return finalCapture;
	}

	public void setFinalCapture(boolean finalCapture) {
		this.finalCapture = finalCapture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public SellerReceivableBreakdown getSellerReceivableBreakdown() {
		return sellerReceivableBreakdown;
	}

	public void setSellerReceivableBreakdown(SellerReceivableBreakdown sellerReceivableBreakdown) {
		this.sellerReceivableBreakdown = sellerReceivableBreakdown;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Capture [amount=" + amount + ", finalCapture=" + finalCapture + ", id=" + id + ", createTime="
				+ createTime + ", links=" + links + ", sellerReceivableBreakdown=" + sellerReceivableBreakdown
				+ ", status=" + status + "]";
	}
}
