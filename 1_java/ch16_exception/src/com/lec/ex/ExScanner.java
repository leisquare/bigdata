package com.lec.ex;

import java.util.Scanner;

public class ExScanner {

		public static void main(String[] args) {

			// 이름, 별명, 나이,
			Scanner scanner = new Scanner(System.in);
			System.out.println("이름을 입력하세요");
			String name = scanner.next();
			System.out.println("입력한 이름은" + name);
			nickName();
			System.out.println("나이를 입력하세요");
			int age = scanner.nextInt();
			System.out.println("입력한 나이는" + age);
			scanner.close();
		}

		public static void nickName() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("별명을 입력하세요");
			String nickName = scanner.next();
			System.out.println("별명은" + nickName);
//			scanner.close(); 여기서 닫아버리면 메인함수에서도 쓸 수 없다. 닫지 않아야함. 
		}

	}
