package com.mega.horoscopo.app.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mega.horoscopo.domain.model.entity.Stats;
import com.mega.horoscopo.domain.service.interfaces.StatsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebInterceptor implements HandlerInterceptor {

	private static final String USER_AGENT = "USER-AGENT";
	
	@Autowired
	private StatsService statsService;

	public WebInterceptor(StatsService statsService) {
		this.statsService = statsService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Stats stats = new Stats();
		stats.setUserIp(request.getRemoteAddr());
		stats.setRequestMethod(request.getMethod());
		stats.setResource(request.getRequestURI());
		stats.setUserAgent(request.getHeader(USER_AGENT));
		
		statsService.registerVisit(stats);
		
		return true;
	}
}
