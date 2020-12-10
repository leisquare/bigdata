package com.lec.ex10_lib.copy;

public class BookInfo {
	private String bookNo;
	private String bookTitle;
	private String writer;

	// 생성자

	public BookInfo() {
	}

	public BookInfo(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
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
}
