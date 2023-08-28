package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paypal {

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

	@Override
	public String toString() {
		return "Paypal [experienceContext=" + experienceContext + ", name=" + name + ", emailAddress=" + emailAddress
				+ ", accountId=" + accountId + "]";
	}
}
