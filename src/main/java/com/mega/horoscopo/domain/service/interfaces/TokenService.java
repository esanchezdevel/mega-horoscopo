package com.mega.horoscopo.domain.service.interfaces;

public interface TokenService {

	/**
	 * Validate if the token is valid
	 * 
	 * @param token The token to be validated
	 * @return True if the token is valid. False if the token is not valid
	 */
	boolean validateToken(String token);
}
