package com.lec.quest;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 :");
		int i = sc.nextInt();
		System.out.println(i%3==0? "3의 배수입니다":"3의 배수가 아닙니다");
		sc.close();
		}

}
