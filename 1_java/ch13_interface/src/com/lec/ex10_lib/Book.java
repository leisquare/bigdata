package com.lec.ex10_lib;

public class Book implements ILendable {
	private String bookNo; // 책 청구번호
	private String bookTitle; // 책제목
	private String writer; // 저자
	private String borrower; // 대출인
	private String checkOutDate; // 대출일(입력)
	private byte state;

	public Book() {
	} // 디폴트 생성자

	public Book(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		this.borrower = borrower;
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state != STATE_NORMAL) {
			System.out.println("대출중인 도서입니다.");
			return;
		}
		// 대출처리 로직
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println("\"" + bookTitle + "\"도서가 대출되었습니다");
	}

	@Override
	public void checkIn() {
		if (state != STATE_BORROWED) {
			System.out.println("대출중인 도서가 아닙니다. 이상합니다.");
			return;
		}
		// 반납처리로직
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\"도서가 반납되었습니다");
	}

	// b.printState() -> 자바, 홍길동 저 -대출가능(대출중)

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.printf("%s, %s저 - 대출가능 \n",bookTitle,writer);
		}else if(state == STATE_BORROWED) {
			System.out.printf("%s, %s저 - 대출중 \n",bookTitle,writer);
		}else {
			System.out.printf("%s, %s저 - 유령상태입니다 \n",bookTitle,writer);
		}
		
		
//			String msg = bookTitle+", "+writer+ "-";
//			msg += state == STATE_NORMAL? "대출가능":"대출중";
//			System.out.println(msg);
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
}
