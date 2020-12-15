package com.lec.ex03_math;
//69.56
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("9.12 올림"+Math.ceil(9.12));
		
		System.out.println("9.12 반올림"+Math.round(9.12));
		
		System.out.println("9.12 버림"+Math.floor(9.12));
		
		System.out.println("소수 첫번째자리에서 반올림, 올림, 버림");
		System.out.println("9.15를 올림: "+Math.ceil(9.15*10)/10);
		System.out.println("9.15를 반올림: "+Math.round(9.15*10)/10.0);
		System.out.println("9.15를 내림: "+Math.floor(9.15*10)/10);
		
		System.out.println("십의 자리에서 반올림, 올림, 버림");
		System.out.println("85를 올림: "+Math.ceil(85/10.0)*10);
		System.out.println("85를 반올림: "+Math.round(85/10.0)*10);
		System.out.println("85를 내림: "+Math.floor(85/10.0)*10);
	}
}
