package com.lec.ex10_lib.copy;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("005.565", "디자인테크닉", "쿠스다"), new BookLib("005.565", "최애굿즈", "전하린"),
				new BookLib("594.5", "요리사랑", "용동희"), new BookLib("833.6", "요리코를위해", "노리즈키"),
				new BookLib("892.9", "뜨개질할머니", "우리") };

		Scanner sc = new Scanner(System.in);
		int fn, idx = 10; 
		String bTitle, borrower, checkOutDate; 
		do {
			System.out.print("1:대출 2:반납 3:도서현황 0:종료");
			fn = sc.nextInt();
			switch (fn) {
			case 1: 
				System.out.println("대출할 책의 이름은?");
				bTitle = sc.next(); 
				// 책조회
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {

						break;
					}
				}
				if (idx == books.length) {
					System.out.println("해당 도서를 보유하고 있지 않습니다.");
				} else if (books[idx].getState() == ILendable.STATE_BORROWED) {
					System.out.println(bTitle + "도서는 대출중입니다");
				} else {
					System.out.println("대출인은?");
					borrower = sc.next();
					System.out.println("대출일은?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
			case 2:
				System.out.println("반납진행");
				System.out.println("반납할 책 이름은?");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 도서가 아닙니다.");
				} else {
					books[idx].checkIn();
				}
				break;
			case 3: // for문으로 도서상태 출력
				System.out.println("도서 상태 출력");
				for (BookLib book : books) {
					book.printState();
				}
			}
		} while (fn != 0);
		System.out.println("시스템 종료");

	}

}