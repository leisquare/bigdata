package com.lec.ex04_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;

	// 생성자
	public Account() {
	}

	public Account(String accountNo, String ownerName) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// 예금하는 메소드
	public void deposit(int amount) { // 계좌정보출력-예금-예금 후 계좌정보 출력
		System.out.println("예금 전: " + this);
		balance += amount;
		System.out.println("예금 후: " + this);
	}

	// 출금하는 메소드
	public void withdraw(int amount) throws Exception {
		if (balance < amount) // 잔액부족으로 강제 예외발생
			throw new Exception(amount + "원 출금하기에는 잔액(현재" + balance + "원)이 부족합니다."); /// 이것이 강제 예외발생
		balance -= amount;
		System.out.println("출금 후: " + this);
	}

	@Override
	public String toString() {
		String result = "계좌번호: " + accountNo + " 예금주 : " + ownerName;

		result += " 잔액" + balance;
		return result;
	}

}
