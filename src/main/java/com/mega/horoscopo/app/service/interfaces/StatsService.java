package com.mega.horoscopo.app.service.interfaces;

import com.mega.horoscopo.domain.model.entity.Stats;

public interface StatsService {

	/**
	 * Register a new visit in the database
	 * 
	 * @param stats The object that contains the visit data
	 */
	void registerVisit(Stats stats);
}
