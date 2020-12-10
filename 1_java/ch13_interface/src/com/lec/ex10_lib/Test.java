package com.lec.ex10_lib;

public class Test {
	public static void main(String[] args) {
		Book book1 = new Book("890a","자바","홍길동");
		Book book2 = new Book("890a","하둡","최민재");
		book1.checkIn();
		book1.checkOut("신길동", "201209");// 대출처리
		book1.checkOut("김길동", "201209");// 대출처리
		book1.printState();
		book2.printState();
	}
}
