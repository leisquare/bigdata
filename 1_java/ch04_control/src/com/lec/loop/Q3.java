package com.lec.loop;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("어느 수의 구구단?");
		int num1 = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			int tot = num1 * i;
			// System.out.printf("%d*%d=%2d\n", num1, i, num1*i);
			// 위의 줄로 입력하면 줄맞춤이 된다. 더 깔끔해보임
			System.out.println(num1 + "*" + i + "=" + tot);
			sc.close();
		}
	}
}

//System.out.printf("%d*%d=%2d\n", num1, i, num1i);