package com.lec.ex05;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("899r-100", "java", "아무개"), new BookLib("899r-101", "하둡", "아무개"),
				new BookLib("899r-102", "오라클", "아무개"), new BookLib("899r-103", "파이썬", "아무개"),
				new BookLib("899r-104", "스파크", "아무개") };

		Scanner sc = new Scanner(System.in);
		int fn = 0, idx = 10;
		String bTitle, borrower, checkOutDate; // 책제목, 대출인 대출일
		do {
			System.out.print("0: 도서현황1:대출 2:반납  그 외:종료");
			try {
				fn = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				System.out.println("시스템 종료");
			}

			switch (fn) {
			case 0: // for문으로 도서상태 출력
				System.out.println("도서 상태 출력");
				for (BookLib BookLib : books) {
					System.out.println(BookLib);
				}
				break;
			case 1: // 책이름 -> 책 조회 -> 해당 책 상태->대출인, 대출일->대출
				System.out.println("대출할 책의 이름은?");
				bTitle = sc.next();
				// 책조회
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				// 책조회에서 책을 찾았는지 못찾았는지 보고 대출 진행
				if (idx == books.length) {
					// 못찾음
					System.out.println("해당 도서를 보유하고 있지 않습니다.");
				} // 찾음 - idx번째것 대출 친행
				else if (books[idx].getState() == ILendable.STATE_BORROWED) {
					System.out.println(bTitle + "도서는 대출중입니다");
				} else {
					System.out.println("대출인은?");
					borrower = sc.next();
					System.out.println("대출일은?");
					checkOutDate = sc.next();
					try {
						books[idx].checkOut(borrower);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case 2: // 책이름 -> 책조회->반납
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
					try {
						books[idx].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
		} while (true);
	}
}