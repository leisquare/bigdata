package com.lec.quest;
import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 :");
		int i = sc.nextInt();
		System.out.println(i%2==0? "짝수입니다":"홀수입니다");
		sc.close();
		}

}


