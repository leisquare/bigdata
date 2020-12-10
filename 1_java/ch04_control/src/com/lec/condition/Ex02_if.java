package com.lec.condition;

public class Ex02_if {
	public static void main(String[] args) {
		int seoulLunchPrice = 8000;
		if(seoulLunchPrice>7000) {
			System.out.println("¼­¿ï¹ä°ªºñ½Î³×");
		}else if(seoulLunchPrice>=6000){
			System.out.println("Àç·á°ª¸¸Å­ÀÌ³×");
		}else if(seoulLunchPrice>=4000){
			System.out.println("¹ä °ª ±¦Âú³×");
		}else{
			System.out.println("ÁÖÀÎÀº ±¦Âú³ª?");
		}
	}
}
