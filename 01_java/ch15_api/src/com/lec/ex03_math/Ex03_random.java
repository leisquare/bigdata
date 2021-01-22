package com.lec.ex03_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*45)+1);
		Random random = new Random();
		System.out.println("int 난수: "+random.nextInt()); //정수
		System.out.println("0~100까지 난수: "+random.nextInt(101));
		System.out.println("0~44까지 int난수 : "+random.nextInt(45));
		System.out.println("1~45까지 int난수: " +random.nextInt(45)+1);
		
		System.out.println("double난수"+random.nextDouble());
		System.out.println("T/F중 하나 선택" +random.nextBoolean());
		
	}
}
