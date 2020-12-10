package com.lec.loop;

// *의 수를 5개까지 늘려가기
public class Ex03_for3 {
	public static void main(String[] args) {
		for (int i = 1; i != 6; i++) {
			for (int j = 1; j<=i; j++) {
				System.out.print("*");
			}
		System.out.println();
		}

	}

}
