package com.lec.loop;

public class Ex05_for_Break {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			if (i == 5) {
				// break; //즉시 멈추고 반복문 블럭을 빠져나가기
				continue; // 멈추고 증감식으로 올라가라!
			}
			System.out.print(i + " ");
		}
	}
}