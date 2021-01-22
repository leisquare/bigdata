package com.lec.ex05;

import java.sql.Date;
import java.util.GregorianCalendar;

public class TestMain {
	public static void main(String[] args) {
		BookLib book = new BookLib("890r-01", "java", "홍길동");
		BookLib book1 = new BookLib("890r-02", "hadoop", "홍민재");
		try {
			book.checkOut("kim");
			book1.checkOut("lee");
			book.setCheckoutDate(new Date(new GregorianCalendar(2020, 10, 30).getTimeInMillis()));
			book.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // try
		System.out.println(book);
		System.out.println(book1);
	}

}
