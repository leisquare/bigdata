package com.lec.ex05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkoutDate;
	private byte state;

	public BookLib() {
	}

	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
	}

	// 대출처리 로직

	@Override
	public void checkOut(String borrower) throws Exception {
		if (state != STATE_NORMAL) {
			throw new Exception("대출중인 도서입니다.");
		}
		this.borrower = borrower;
		state = STATE_BORROWED;
		System.out.println("\"" + bookTitle + "\"도서가 대출되었습니다");
	}

	// 반납처리로직

	@Override
	public void checkIn() throws Exception {
		if (state != STATE_BORROWED) {
			throw new Exception("대출중인 도서가 아닙니다. 이상합니다.");
		}
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd(E)");
		long diff = now.getTime() - checkoutDate.getTime(); //
		long day = diff / (1000 * 60 * 60 * 24); //
		// 연체료 로직
		if (day > 14) {
			day = day - 14;
			System.out.println("대출일은 "+sdf.format(checkoutDate));
			System.out.println("연체료" + (day * 100) + "원을 받으셨나요?(Y/N)");
			Scanner scanner = new Scanner(System.in);
			String ok = scanner.next();
			if (!ok.equalsIgnoreCase("y")) {
				System.out.println("연체료 미납시 반납처리 불가.");
				return; // 메인함수로 돌아감.
			}
		} // 반납완료
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\"도서가 반납되었습니다");

	}

	@Override
	public String toString() {
		if (state == STATE_NORMAL) {
			String result = bookTitle + "," + writer + "저- 대출가능";
			return result;
		} else if (state == STATE_BORROWED) {
			String result = bookTitle + "," + writer + "저- 대출중";
			return result;
		} else {
			String result = bookTitle + "," + writer + "저- 유령도서입니다.";
			return result;
		}

	}
	// 겟셋

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

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
