package com.mega.horoscopo.domain.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "week_content")
public class WeekContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String year;
	
	private String week;
	
	@OneToMany(mappedBy = "weekContent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Content> content;
	
	// token used to validate if one user has pay to see the content
	private String token;
	
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

	public String getYear() {
		return year;
	}

	public String getWeek() {
		return week;
	}

	public List<Content> getContent() {
		return content;
	}

	public String getToken() {
		return token;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public String toString() {
		return "WeekContent [id=" + id + ", year=" + year + ", week=" + week + ", content=" + content + ", token="
				+ token + ", created=" + created + ", lastUpdate=" + lastUpdate + "]";
	}
}
