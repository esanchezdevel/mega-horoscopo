package com.mega.horoscopo.domain.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "stats")
public class Stats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_ip")
	private String userIp;
	
	@Column(name = "request_method")
	private String requestMethod;
	
	private String resource;
	
	@Column(name = "user_agent")
	private String userAgent;
	
	@CreatedDate
	private LocalDateTime created;

	@PrePersist
	public void prePersist() {
		created = LocalDateTime.now();
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Stats [id=" + id + ", userIp=" + userIp + ", requestMethod=" + requestMethod + ", resource=" + resource
				+ ", userAgent=" + userAgent + ", created=" + created + "]";
	}
}
