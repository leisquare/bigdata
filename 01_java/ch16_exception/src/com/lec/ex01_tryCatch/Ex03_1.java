package com.lec.ex01_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.println("첫번째 수는?");
				i = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("첫번째 수에 문자를 넣지 마세요");
				scanner.nextLine(); // 버퍼를 지우는 목적

			}
		} while (true);

		System.out.println("두번째 수는?");
		try {
			j = scanner.nextInt();

			System.out.println("i=" + i + ", j+" + j);
			System.out.println("i*j=" + (i * j));
			try {
				System.out.println("i/j=" + (i / j));
				}catch(ArithmeticException e) {
					System.out.println(e.getMessage()+" 0으로 나누는 것은 패스.");
				}
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("두번째 수를 잘못 입력하여 1로 초기화");
		}

		System.out.println("i+j=" + (i + j));
		System.out.println("i-j=" + (i - j));
		System.out.println("끝");
		scanner.close();
	}
	
	
	
	
	

}
