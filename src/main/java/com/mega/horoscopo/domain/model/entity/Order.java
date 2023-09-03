package com.mega.horoscopo.domain.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "request_id")
	private String requestId;
	
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_surname")
	private String userSurname;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "payer_id")
	private String payerId;
	
	@Column(name = "user_account_id")
	private String userAccountId;
	
	@Column(name = "purchase_reference_id")
	private String purchaseReferenceId;
	
	@Column(name = "refund_url")
	private String refundUrl;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "net_amount")
	private double netAmount;
	
	@Column(name = "paypal_fee")
	private double paypalFee;
	
	private String currency;
	
	private String status;
	
	@Column(name = "horoscope_sign")
	private String horoscopeSign;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@CreatedDate
	private LocalDateTime created;

	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	@PrePersist
	public void prePersist() {
		created = LocalDateTime.now();
		lastUpdate = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		lastUpdate = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getPurchaseReferenceId() {
		return purchaseReferenceId;
	}

	public void setPurchaseReferenceId(String purchaseReferenceId) {
		this.purchaseReferenceId = purchaseReferenceId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHoroscopeSign() {
		return horoscopeSign;
	}

	public void setHoroscopeSign(String horoscopeSign) {
		this.horoscopeSign = horoscopeSign;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getRefundUrl() {
		return refundUrl;
	}

	public void setRefundUrl(String refundUrl) {
		this.refundUrl = refundUrl;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getPaypalFee() {
		return paypalFee;
	}

	public void setPaypalFee(double paypalFee) {
		this.paypalFee = paypalFee;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", requestId=" + requestId + ", orderId=" + orderId + ", userName=" + userName
				+ ", userSurname=" + userSurname + ", userEmail=" + userEmail + ", payerId=" + payerId
				+ ", userAccountId=" + userAccountId + ", purchaseReferenceId=" + purchaseReferenceId + ", refundUrl="
				+ refundUrl + ", totalAmount=" + totalAmount + ", netAmount=" + netAmount + ", paypalFee=" + paypalFee
				+ ", currency=" + currency + ", status=" + status + ", horoscopeSign=" + horoscopeSign
				+ ", countryCode=" + countryCode + ", created=" + created + ", lastUpdate=" + lastUpdate + "]";
	}
}
