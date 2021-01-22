package com.lec.ex1_;

import com.lec.cons.PiClass;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	//private final int HOURLYRATE = 2000; // Final이 붙으면 다른 곳에서 수정 불가능. 상수를 선언할때는 모든 글자를 대문자로 선언한다.

	// 생성자
	public Parking() {
	}

	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println(no + "님 어서오세요");
		System.out.println("입차시간 : " + inTime + "시");

	}

	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime - inTime) * PiClass.HOURYRATE;
		System.out.println("입차시간 : " + inTime + "시");
		System.out.println("출차시간 : " + outTime + "시");
		System.out.println("주차요금 : " + fee + "원");
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
}
