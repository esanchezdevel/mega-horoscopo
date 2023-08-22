package com.mega.horoscopo.domain.service.impl;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mega.horoscopo.domain.model.entity.WeekContent;
import com.mega.horoscopo.domain.model.repository.WeekContentRepository;
import com.mega.horoscopo.domain.service.interfaces.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

	private static final Logger logger = LogManager.getLogger(TokenServiceImpl.class);
	
	@Autowired
	private WeekContentRepository weekContentRepository;
	
	@Override
	public boolean validateToken(String token) {
		boolean isValid = false;
		if (token == null || token.isEmpty()) {
			logger.info("Empty token");
			return isValid;
		}
		LocalDate currentDate = LocalDate.now();
		
		String currentYear = String.valueOf(currentDate.getYear());
		
		WeekFields weekFields = WeekFields.of(Locale.getDefault());  
	    String currentWeek = String.valueOf(currentDate.get(weekFields.weekOfWeekBasedYear()));
	    
	    logger.info("current year: {}, current week: {}", currentYear, currentWeek);
	    
	    Optional<WeekContent> weekContent = weekContentRepository.findByYearAndWeek(currentYear, currentWeek);
	    
	    if (weekContent.isPresent()) {
	    	logger.info("Token found in database. Is valid");
	    	isValid = true;
	    }
	    
		return isValid;
	}
}
