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
	
	private String price;
	
	private String currency;
	
	private String status;
	
	@Column(name = "horoscope_sign")
	private String horoscopeSign;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", requestId=" + requestId + ", orderId=" + orderId + ", userName=" + userName
				+ ", userSurname=" + userSurname + ", userEmail=" + userEmail + ", payerId=" + payerId
				+ ", userAccountId=" + userAccountId + ", purchaseReferenceId=" + purchaseReferenceId + ", created="
				+ created + ", lastUpdate=" + lastUpdate + ", price=" + price + ", currency=" + currency + ", status="
				+ status + ", horoscopeSign=" + horoscopeSign + "]";
	}
}
