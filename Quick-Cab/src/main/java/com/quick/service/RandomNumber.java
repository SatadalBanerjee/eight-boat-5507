package com.quick.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomNumber {

	public String RandomNum() {
		
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	
	}
}
