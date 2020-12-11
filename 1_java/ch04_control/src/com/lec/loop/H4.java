package com.lec.loop;

import java.util.Scanner;

public class H4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("가위(-),바위(1),보(2)중 하나를 선택:");
			int you = scanner.nextInt();
			if (you == 0) {
				System.out.println("가위!");
			} else if (you == 1) {
				System.out.println("바위!");
			} else if (you == 2) {
				System.out.println("보!");
			} else if (you == -1) {
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				System.out.println("떼끼");
			}

			// 컴퓨터
			int computer = (int) (Math.random() * 3);
			if (computer == 0) {
				System.out.println("가위!");
			} else if (computer == 1) {
				System.out.println("바위!");
			} else if (computer == 2) {
				System.out.println("보!");
			} else {
				System.out.println("떼끼");
			}
			// 승패판정
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