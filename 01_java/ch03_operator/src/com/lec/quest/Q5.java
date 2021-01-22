package com.lec.quest;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner lang = new Scanner(System.in);
		System.out.print("국어점수를 입력하세요 :");
		int a = lang.nextInt();
		Scanner math = new Scanner(System.in);
		System.out.print("수학점수를 입력하세요 :");
		int b = math.nextInt();
		Scanner eng = new Scanner(System.in);
		System.out.print("영어점수를 입력하세요 :");
		int c = eng.nextInt();
		
		int resultSum;
		resultSum = (a+b+c);
		double resultAverage;
		resultAverage = (double)((a+b+c)/3.0);
		System.out.printf("입력하신 점수는 국어 %d점 수학 %d점 영어 %d점입니다.",a,b,c);
		System.out.printf("총점은 %d점 평균은 %.2f점입니다.",resultSum,resultAverage);
		math.close();
		lang.close();
		eng.close();
		}

/*resultDouble = (double)(n1 / n2);
	System.out.printf("%d %c %d = %.3f\n", n1, '/', n2, resultDouble);
*/
	
}
