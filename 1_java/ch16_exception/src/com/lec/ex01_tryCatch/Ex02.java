package com.lec.ex01_tryCatch;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
		System.out.println("첫번째 수는?");
		i = scanner.nextInt();
		System.out.println("두번째 수는?");
		j = scanner.nextInt();
		System.out.println("i=" + i + ", j+" + j);
		System.out.println("i*j=" + (i * j));
		try {
			System.out.println("i/j=" + (i / j));
		} catch (ArithmeticException e) {
			e.printStackTrace(); // 예외상황을 자세히 출력
			System.out.println(e.getMessage()); // 예외메세지만 출력
		}
		System.out.println("i+j=" + (i + j));
		System.out.println("i-j=" + (i - j));
		System.out.println("끝");
//		scanner.close();
	}

}
