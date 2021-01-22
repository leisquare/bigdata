package com.lec.ex10_lib;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		Book[] books = { new Book("899r-100", "java", "아무개"), new Book("899r-101", "하둡", "아무개"),
				new Book("899r-102", "오라클", "아무개"), new Book("899r-103", "파이썬", "아무개"),
				new Book("899r-104", "스파크", "아무개") };

		Scanner sc = new Scanner(System.in);
		int fn, idx = 10; // 기능번호(1 대출, 2 반납), 인덱스(책)
		String bTitle, borrower, checkOutDate; // 책제목, 대출인 대출일
		do {
			System.out.print("1:대출 2:반납 3:도서현황 0:종료");
			fn = sc.nextInt();
			switch (fn) {
			case 1: // 책이름 -> 책 조회 -> 해당 책 상태->대출인, 대출일->대출
				System.out.println("대출할 책의 이름은?");
				bTitle = sc.next(); // 스트링을 받기 위해 next를 사용. 정수를 받는건 nextint, 스트링은 nextline이나 next
				// 책조회
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						// 찾았다. 해당 idx번째 대출하자
						break;
					}
				}
				// 책조히ㅗ에서 책을 찾았는지 못찾았는지 보고 대출 진행
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
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
			case 2: // 책이름 -> 책조회->반납
				System.out.println("반납진행");
				System.out.println("반납할 책 이름은?");
				bTitle = sc.next();
				for(idx = 0; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx ==books.length) {
					System.out.println("해당 도서는 본 도서관의 도서가 아닙니다.");
				}else {
					books[idx].checkIn();	
				}
				break;
			case 3: // for문으로 도서상태 출력
				System.out.println("도서 상태 출력");
				for (Book book : books) {
					book.printState();
				}
			}
		} while (fn != 0);
		System.out.println("시스템 종료");

	}
	
}