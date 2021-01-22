package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요: ");
		int age = scanner.nextInt();
		System.out.println("입력한 나이는" + age);
		System.out.println("이름을 입력하세요: ");
		String name = scanner.next();
		System.out.println("입력한 이름은" + name);
		System.out.print("주소를 입력하세요");

		scanner.nextLine(); // 버퍼에 남은 것 지워주는 역할. 지워주지 않으면 nextline의 효과 때문에 버퍼에 이상한게 남을수도 있따.

		String address = scanner.nextLine(); // 버퍼에 \n이 나오는 앞까지 취하기
		System.out.println("입력하신 주소는~" + address);
		System.out.println("========프로그램 끝===========");
	}

}