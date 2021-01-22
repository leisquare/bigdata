package com.lec.ex01_tryCatch;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
		System.out.println("첫번째 수는?");
		i = scanner.nextInt();
		System.out.println("두번째 수는?");
		j= scanner.nextInt();
		System.out.println("i="+i+", j+"+j);
		System.out.println("i*j="+(i*j));
		System.out.println("i/j="+(i/j));
		System.out.println("i+j="+(i+j));
		System.out.println("i-j="+(i-j));
		System.out.println("끝");
//		scanner.close();
	}

}
