package com.mega.horoscopo.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mega.horoscopo.app.service.interfaces.SignService;
import com.mega.horoscopo.domain.service.interfaces.TokenService;

@Service
public class SignServiceImpl implements SignService {

	private static final String PAGE_SIGN = "sign";
	private static final String PAGE_PAYMENT = "payment";
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	public String execute(String token) {
		return tokenService.validateToken(token) ? PAGE_SIGN : PAGE_PAYMENT;
	}
}
