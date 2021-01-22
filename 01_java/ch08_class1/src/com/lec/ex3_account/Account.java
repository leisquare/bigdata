package com.lec.ex3_account;

/* 은행계좌 클래스
 * 데이터(속성): 계좌번호(accountNo:String), 예금주(ownerName:String), 잔액(balance:Long)
 * 기능(메소드): 예금(void deposit(int money),   new Account("110-352","홍",10)
 * 인출(void withdraw(int money)), new Account("110-352","홍")
 * 잔액조회?(int getBalance())
 * 
 * 
 */
public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;

//생성자
	public Account() {
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

//메서드
	//예금
	public void deposit(int money) { // 예금은 무조건 성공
		balance += money;
	}
	//인출
	public void withdraw(int money) { // 잔액부족시 "주의" return
		if (balance >= money) {
			balance -= money;
		} else {
			System.out.println("잔액부족. 주의");
		}
	}
	//잔액조회
	public int getBalance() {
		return balance;
	}
	//인포
	public void info() {
		System.out.println("계좌번호: "+accountNo+ ", "+ownerName+ "님 잔액은 "+balance);
	}

//겟셋
	// 계좌번호
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	// 예금주
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	// 잔액
	public int balance() {
		return balance;
	}

	public void setbalance(int balance) {
		this.balance = balance;
	}

}