package com.lec.ex10_lib;

public interface ILendable {
	public byte STATE_BORROWED= 1; //대출중
	public byte STATE_NORMAL= 0; //대출 가능
	public void checkOut(String borrower, String checkOutDate); //대출
	public void checkIn(); //반납
	public void printState();// "자바" 홍길동 저 대출가능
							// "자바" 홍길동 저 대출중
}
