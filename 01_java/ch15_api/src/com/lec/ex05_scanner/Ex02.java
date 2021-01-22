package com.lec.ex05_scanner;

import java.util.Scanner;

//cf. next()->nextLine()로 버퍼 주익.-> nextLine 이용
//nextLine()이용 -> Next 이용
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주소를 입력하세요.");
		String address = scanner.nextLine();
		System.out.println("입력하신 주소는 " + address);
		System.out.println("이름을 입력하세요.");
		String name = scanner.nextLine(); //space 포함
		System.out.println("입력하신 이름은 "+name);
		System.out.println("나이를 입려하세요.");
		int age = scanner.nextInt();
		System.out.println("입력하신 나이는"+age);
	}
//버퍼의 상태를 고려하며 짜자.
}
