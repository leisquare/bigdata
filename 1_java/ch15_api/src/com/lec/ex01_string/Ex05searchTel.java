package com.lec.ex01_string;

import java.util.Scanner;

public class Ex05searchTel {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-8888", "010-7777-7777" };
		Scanner scanner = new Scanner(System.in);
		int idx; // 전화번호가 중복이 없을 때 
		System.out.println("찾고자하는 전화번호 뒷자리: ");
		String searchTel = scanner.next(); //8888
		
		for(idx = 0; idx<tels.length ; idx++) {
			String temp = tels[idx];
			String post = temp.substring(temp.lastIndexOf("-")+1);
			if(searchTel.equals(post)) {
				System.out.println(tels[idx]);
				break;
			}//if
		}//for
		if(idx==tels.length) {
			System.out.println("입력하신 전화번호는 없는 번호입니다.");
		}
	}//main
}//class
