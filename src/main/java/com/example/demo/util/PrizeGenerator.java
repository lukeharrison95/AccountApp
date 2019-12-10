package com.example.demo.util;

import org.springframework.stereotype.Service;

@Service
public class PrizeGenerator {
		public double prizeGen(String accNo) {
			if( accNo.toLowerCase().startsWith("b")) {
				if(accNo.length() == 7) {
					return 50;
				}
				if(accNo.length() == 9) {
					return 500;
				}
				if(accNo.length() == 11) {
					return 5000;
				}
			}
			else if(accNo.toLowerCase().startsWith("c")) {
				if(accNo.length() == 7) {
					return 100;
				}
				if(accNo.length() == 9) {
					return 750;
				}
				if(accNo.length() == 11) {
					return 10000;
				}
			}
			return 0;
		}
}