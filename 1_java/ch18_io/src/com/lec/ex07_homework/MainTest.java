package com.lec.ex07_homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, tel, birth, address, key;
		ArrayList<Customer> customers = new ArrayList<Customer>();

		PrintWriter printWriter = null;
		OutputStream os = null;
		Writer writer = null;

		do {
			System.out.println("회원가입 진행하시겠습니까? (Y/N)");
			key = sc.next(); // Y,y,n,N중에 하나 눌렀겠지~
			if (key.equalsIgnoreCase("y")) { // 회원가입 진행
				System.out.println("가입하실 회원님 이름은?");
				name = sc.next();
				System.out.println("가입하실 회원님 전화번호는?");
				tel = sc.next();
				System.out.println("가입하실 회원님 생일은?");
				birth = sc.next();
				System.out.println("가입하실 회원님 주소는?");
				sc.nextLine();
				address = sc.nextLine();
			} else if (key.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);

		System.out.println("가입한 회원목록 리스트");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		
		try {
			writer = new FileWriter("txtFile/customer.txt");
			printWriter = new PrintWriter(writer); // 스트림 객체생성

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (printWriter != null)
					printWriter.close();
			} catch (Exception e) {

			}
		}

	}
}
