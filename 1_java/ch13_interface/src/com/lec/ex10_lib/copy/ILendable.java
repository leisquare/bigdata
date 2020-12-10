package com.lec.ex10_lib.copy;

public interface ILendable {
	public byte STATE_BORROWED = 1; //대출중
	public byte STATE_NORMAL = 0; //대출 가능
	public void checkOut(String borrower, String checkOutDate); 
	public void checkIn(); //반납
	public void printState(); //상태확인
	
}
