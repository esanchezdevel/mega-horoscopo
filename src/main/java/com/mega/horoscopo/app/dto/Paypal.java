package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paypal {

	@JsonProperty("experience_context")
	private ExperienceContext experienceContext;

	public ExperienceContext getExperienceContext() {
		return experienceContext;
	}

	public void setExperienceContext(ExperienceContext experienceContext) {
		this.experienceContext = experienceContext;
	}

	@Override
	public String toString() {
		return "Paypal [experienceContext=" + experienceContext + "]";
	}
}
