package com.lec.loop;

import java.util.Scanner;

public class Ex09_dowhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			// 사용자로부터 입력받은 수를 num에 할당
			System.out.print("짝수를 입력하세요.: ");
			num = scanner.nextInt();
		} while ( /* num이 홀수냐? */ num % 2 == 1||num%2==-1);
		System.out.println("입력하신 짝수는" + num);
	}

}
