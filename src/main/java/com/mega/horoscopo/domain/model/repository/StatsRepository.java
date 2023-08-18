package com.mega.horoscopo.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mega.horoscopo.domain.model.entity.Stats;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {

}
