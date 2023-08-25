package com.mega.horoscopo.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExperienceContext {

	@JsonProperty("payment_method_preference")
	private String paymentMethodPreference;
	
	@JsonProperty("brand_name")
	private String brandName;
	
	private String locale;
	
	@JsonProperty("landing_page")
	private String landingPage;
	
	@JsonProperty("shipping_preference")
	private String shippingPreference;
	
	@JsonProperty("user_action")
	private String userAction;
	
	@JsonProperty("return_url")
	private String returnUrl;
	
	@JsonProperty("cancelUrl")
	private String cancelUrl;

	public String getPaymentMethodPreference() {
		return paymentMethodPreference;
	}

	public void setPaymentMethodPreference(String paymentMethodPreference) {
		this.paymentMethodPreference = paymentMethodPreference;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLandingPage() {
		return landingPage;
	}

	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}

	public String getShippingPreference() {
		return shippingPreference;
	}

	public void setShippingPreference(String shippingPreference) {
		this.shippingPreference = shippingPreference;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	@Override
	public String toString() {
		return "ExperienceContext [paymentMethodPreference=" + paymentMethodPreference + ", brandName=" + brandName
				+ ", locale=" + locale + ", landingPage=" + landingPage + ", shippingPreference=" + shippingPreference
				+ ", userAction=" + userAction + ", returnUrl=" + returnUrl + ", cancelUrl=" + cancelUrl + "]";
	}
}
