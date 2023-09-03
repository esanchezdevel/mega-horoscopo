package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payer {

	private Address address;
	
	private Name name;
	
	@JsonProperty("email_address")
	private String emailAddress;
	
	@JsonProperty("payer_id")
	private String payerId;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Payer [address=" + address + ", name=" + name + ", emailAddress=" + emailAddress + ", payerId="
				+ payerId + "]";
	}
}
