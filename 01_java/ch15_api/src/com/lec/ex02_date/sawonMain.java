package com.lec.ex02_date;

public class sawonMain {
	public static void main(String[] args) {
		sawon s1 = new sawon("a01", "홍", PartType.COMPUTER);
		sawon s2 = new sawon("a13", "홍", PartType.COMPUTER, 2020, 11, 14);
		System.out.println(s1);
		System.out.println(s2);
	}
}

