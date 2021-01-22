package com.lec.ex05;

public interface ILendable {
	final static byte STATE_BORROWED = 1;
	final static byte STATE_NORMAL = 0;
	public void checkOut(String borrower) throws Exception;
	public void checkIn() throws Exception;
}