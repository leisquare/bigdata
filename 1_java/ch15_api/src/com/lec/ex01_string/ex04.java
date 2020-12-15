package com.lec.ex01_string;

import java.util.Scanner;

public class ex04 {

	public static void main(String[] args) {
		Ex03_quiz ex = new Ex03_quiz();
		System.out.println(ex.getClass().getName());

		System.out.println("번호를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		System.out.println("입력한 전화번호는" + num);
		System.out.print("짝수번째 문자열:");
		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0) {
				System.out.print(num.charAt(i));
			}
		}
		System.out.println("");
		System.out.print("문자를 거꾸로: ");
		for (int i = num.length() - 1; i >= 0; i--) {
			System.out.print(num.charAt(i));
		}

	}
}
