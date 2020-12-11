package com.lec.loop;

import java.util.Scanner;

public class Ex09_dowhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			// ����ڷκ��� �Է¹��� ���� num�� �Ҵ�
			System.out.print("¦���� �Է��ϼ���.: ");
			num = scanner.nextInt();
		} while ( /* num�� Ȧ����? */ num % 2 == 1 || num % 2 == -1);
		System.out.println("�Է��Ͻ� ¦����" + num);
	}
}
