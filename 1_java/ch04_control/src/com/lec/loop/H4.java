package com.lec.loop;

import java.util.Scanner;

public class H4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("����(-),����(1),��(2)�� �ϳ��� ����:");
			int you = scanner.nextInt();
			if (you == 0) {
				System.out.println("����!");
			} else if (you == 1) {
				System.out.println("����!");
			} else if (you == 2) {
				System.out.println("��!");
			} else if (you == -1) {
				System.out.println("������ �����մϴ�.");
				break;
			} else {
				System.out.println("����");
			}

			// ��ǻ��
			int computer = (int) (Math.random() * 3);
			if (computer == 0) {
				System.out.println("����!");
			} else if (computer == 1) {
				System.out.println("����!");
			} else if (computer == 2) {
				System.out.println("��!");
			} else {
				System.out.println("����");
			}
			// ��������
			if ((you + 2) % 3 == computer) {
				System.out.println(("you win! bye!"));
				break;
			} else if ((you + 2) % 3 < computer) {
				System.out.println("draw");
			} else {
				System.out.println("you lose");
			}
		}
		scanner.close();
	}
}