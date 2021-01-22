package com.lec.quest;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("나이를 입력하세요 :");
		int i = sc1.nextInt();
		System.out.println(i>=65? "경로우대":"일반");
		sc1.close();
		}

}
