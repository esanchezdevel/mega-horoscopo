package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paypal {

	@JsonProperty("account_status")
	private String accountStatus;
	
	private Address address;
	
	@JsonProperty("experience_context")
	private ExperienceContext experienceContext;

	private Name name;
	
	@JsonProperty("email_address")
	private String emailAddress;
	
	@JsonProperty("account_id")
	private String accountId;
	
	public ExperienceContext getExperienceContext() {
		return experienceContext;
	}

	public void setExperienceContext(ExperienceContext experienceContext) {
		this.experienceContext = experienceContext;
	}
	
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Paypal [accountStatus=" + accountStatus + ", address=" + address + ", experienceContext="
				+ experienceContext + ", name=" + name + ", emailAddress=" + emailAddress + ", accountId=" + accountId
				+ "]";
	}
}
