package com.lec.quest;
//두 수를 입력받아 두 수가 같은지 결과를 o나 x로 출력

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner first = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요 :");
		int a = first.nextInt();
		Scanner second = new Scanner(System.in);
		System.out.print("두번째 숫자를 입력하세요 :");
		int b = second.nextInt();

		System.out.println("두 수는 같은 수인가요?");
		System.out.println(a==b? "O":"X");
		System.out.println("첫번째 입력한 수 a가 더 큰가요?");
		System.out.println(a>b? "O":"X");
		first.close();
		second.close();
	
		
	}
}

