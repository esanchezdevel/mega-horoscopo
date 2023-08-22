package com.mega.horoscopo.domain.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mega.horoscopo.domain.model.entity.WeekContent;

@Repository
public interface WeekContentRepository extends JpaRepository<WeekContent, Long>{

	Optional<WeekContent> findByYearAndWeek(String year, String week);
}
