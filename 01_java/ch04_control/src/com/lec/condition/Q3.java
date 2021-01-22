package com.lec.condition;

import java.util.Random;
import java.util.Scanner;

//사용자로부터 가위(0)바위(1)보(2)중 입력받고, 컴퓨터도 하나를 선택해 승자를 출력
public class Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위(-),바위(1),보(2)중 하나를 선택:");
		int you = scanner.nextInt();
		if (you == 0) {
			System.out.println("가위!");
		} else if (you == 1) {
			System.out.println("바위!");
		} else if (you == 2) {
			System.out.println("보!");
		} else {
			System.out.println("떼끼");
			System.exit(0);
		}
		scanner.close();
//컴퓨터
		int computer = (int) (Math.random() * 3); // math random은 0~1까지.
		if (computer == 0) {
			System.out.println("가위!");
		} else if (computer == 1) {
			System.out.println("바위!");
		} else if (computer == 2) {
			System.out.println("보!");
		} else {
			System.out.println("떼끼");
		}
//승패판정
		if ((you + 2) % 3 == computer) {
			System.out.println(("you win"));
		} else if ((you + 2) % 3 < computer) {
			System.out.println("draw");
		} else {
			System.out.println("you lose");
		}
	}// main함수
}// class