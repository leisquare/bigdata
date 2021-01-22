package com.lec.ex;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in); //이것과 똑같은 구조로 사용한다.
	int su = -5;
	System.out.println(su+"의 절대값은 "+Arithmetic.abs(su));
		
		Arithmetic ar = new Arithmetic(); //Arithmetic형 객체. 
		int sum = ar.sum(10, 51);
		System.out.println("합은"+sum);
		System.out.println(ar.evenOdd(sum));
		sum = ar.sum(50);
		System.out.println("합은"+sum);
		System.out.println(ar.evenOdd(sum));
		
	}
}


//static을 안 쓰면 ar. 을 써서 불러야하고, static을 쓰면 막 불러서 쓸 수 있다.
//static은 클래스로 바로 사용할 수 있는 것이다. 그러나 너무 쓰면 메모리에 부하가 걸린다.
//해당 폴더(같은 패키지)에는 없는 객체 불러올때는 import 써야함.
