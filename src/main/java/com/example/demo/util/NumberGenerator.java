package com.example.demo.util;

import java.util.Random;


public class NumberGenerator {

	char[] abcArray = {'A', 'B', 'C'};
	int[] lengthArray = {6, 8, 10};
	Random rand = new Random();
	
	public String genNumber() {
		StringBuilder accNo = new StringBuilder();
		char abc = abcArray[rand.nextInt(3)];
		int length = lengthArray[rand.nextInt(3)];
		accNo.append(abc);
		for (int i = 0; i < length; i++) {
			accNo.append(rand.nextInt(10));
		}
		return accNo.toString();
	}

}
