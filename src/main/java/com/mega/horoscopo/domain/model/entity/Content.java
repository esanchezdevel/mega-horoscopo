package com.mega.horoscopo.domain.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "content")
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sign;

	private String content;

	@ManyToOne
	@JoinColumn(name = "id_week_content")
	private WeekContent weekContent;

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

	public String getSign() {
		return sign;
	}

	public String getContent() {
		return content;
	}

	public WeekContent getWeekContent() {
		return weekContent;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", sign=" + sign + ", content=" + content + ", weekContent=" + weekContent
				+ ", created=" + created + ", lastUpdate=" + lastUpdate + "]";
	}
}
