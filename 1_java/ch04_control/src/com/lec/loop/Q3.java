package com.lec.loop;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��� ���� ������?");
		int num1 = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			int tot = num1 * i;
			//System.out.printf("%d*%d=%2d\n", num1, i, num1*i);
			//���� �ٷ� �Է��ϸ� �ٸ����� �ȴ�. �� ����غ���
			System.out.println(num1 + "*" + i + "=" + tot);
			sc.close();
		}
	}
}


//System.out.printf("%d*%d=%2d\n", num1, i, num1i);