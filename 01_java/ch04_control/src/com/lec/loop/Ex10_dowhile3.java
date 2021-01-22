package com.lec.loop;

import java.util.Scanner;

public class Ex10_dowhile3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lotto = (int) (Math.random() * 45) + 1; // 컴퓨터 난수
		int su; // 사용자에게 입력받은 수를 저장하는 변수
		System.out.println(lotto);
		do {
			System.out.print("로또 번호 한개를 맞춰보세요");
			su = scanner.nextInt();
			if (su > lotto) {
				System.out.println(su + "보다 작은 수를 도전하세요");
			} else if (su < lotto) {
				System.out.println(su + "보다 큰 수를 도전하세요");
			}
		} while (su != lotto);
		System.out.println("축하합니다!");

		scanner.close();
	}

}

//System.out.println(Math.random()); //0이상 1미만 난수 실수
//System.out.println(Math.random()*45); //0이상 45미만 난수 실수
//System.out.println((int)(Math.random())*45); //0~44 난수 정수
//System.out.println((int)(Math.random())*45+1); //1~45 난수 정수