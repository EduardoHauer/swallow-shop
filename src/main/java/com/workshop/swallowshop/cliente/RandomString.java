package com.workshop.swallowshop.cliente;

import java.security.SecureRandom;

public class RandomString {

	
	private static final String CARACTERES= "ABCDEFGHIJKLMNOPKRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	
	public static String randomizadorDeString(int length) {
		
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < length ; i++) {
			
			int index = secureRandom.nextInt(CARACTERES.length());
			sb.append(CARACTERES.indexOf(index));
		}
		return sb.toString();
	}
}
