package com.mega.horoscopo.app.service.interfaces;

public interface SignService {

	/**
	 * Execute all needed actions related to the sign page
	 * 
	 * @param token The token that needs to be validated
	 * @return The string of the page to show
	 */
	String execute(String token);
}
