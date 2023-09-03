package com.mega.horoscopo.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

	private List<Capture> captures;

	public List<Capture> getCaptures() {
		return captures;
	}

	public void setCaptures(List<Capture> captures) {
		this.captures = captures;
	}

	@Override
	public String toString() {
		return "Payment [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
