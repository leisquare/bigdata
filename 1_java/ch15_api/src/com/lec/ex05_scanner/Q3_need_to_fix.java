package com.lec.ex05_scanner;
//package com.lec.ex5_scanner;
//
//import java.util.Random;
//import java.util.Scanner;
//
////사용자로부터 가위(0)바위(1)보(2)중 입력받고, 컴퓨터도 하나를 선택해 승자를 출력
//public class Q3_need_to_fix {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		do {
//			System.out.println("가위(0),바위(1),보(2)중 하나를 선택(당신이 이길때까지):");
//						input = sc.nextLine().trim();
//			int you = scanner.nextInt();
//			if (you == 0) {
//				System.out.println("가위!");
//			} else if (you == 1) {
//				System.out.println("바위!");
//			} else if (you == 2) {
//				System.out.println("보!");
//			} else {
//				System.out.println("떼끼");
//				System.exit(0);
//			}
//			
////컴퓨터
//			int computer = (int) (Math.random() * 3); // math random은 0~1까지.
//			if (computer == 0) {
//				System.out.println("가위!");
//			} else if (computer == 1) {
//				System.out.println("바위!");
//			} else if (computer == 2) {
//				System.out.println("보!");
//			} else {
//				System.out.println("떼끼");
//			}
////승패판정
//			if ((you + 2) % 3 == computer) {
//				System.out.println(("you win"));
//				win = true;
//			} else if ((you + 2) % 3 < computer) {
//				System.out.println("draw");
//			} else {
//				System.out.println("you lose");
//			}
//		} while (win != true);
//		scanner.close();
//
//	}// main함수
//}// class
