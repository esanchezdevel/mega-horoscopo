package com.mega.horoscopo.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mega.horoscopo.domain.model.entity.Stats;
import com.mega.horoscopo.domain.model.repository.StatsRepository;
import com.mega.horoscopo.domain.service.interfaces.StatsService;

@Service
public class StatsServiceImpl implements StatsService {

	@Autowired
	private StatsRepository statsRepository;
	
	@Override
	public void registerVisit(Stats stats) {
		statsRepository.save(stats);
	}
}
