package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex05_CustomerMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();

		do {
			System.out.println("회원가입 진행하시겠습니까? (Y/N)");
			answer = scanner.next(); // Y,y,n,N중에 하나 눌렀겠지~
			if (answer.equalsIgnoreCase("y")) { // 회원가입 진행
				System.out.println("가입하실 회원님 이름은?");
				name = scanner.next();
				System.out.println("가입하실 회원님 전화번호는?");
				phone = scanner.next();
				System.out.println("가입하실 회원님 주소는?");
				scanner.nextLine();
				address = scanner.nextLine();
			} else if (answer.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);
		
		System.out.println("가입한 회원목록 리스트");
		for (Customer customer : customers){
			System.out.println(customer);
		}
		for(int idx = 0; idx<customers.size(); idx++) {
			System.out.println(customers.get(idx));
		}
	}

}
