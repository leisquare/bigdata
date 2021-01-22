package com.lec.ex06_account;

public class Account {
	private int balance;

	public Account() {
	}

	public Account(int balance) {
		this.balance = balance;
	}

	public synchronized void deposit(int amount, String who) {
		System.out.println(who + "가 입금 시작~~");
		System.out.println("입금 전 잔액 " + balance);
		balance += amount;
		System.out.println("입금 후 잔액 " + balance);
		System.out.println(who + "가 입금 끝~~");
	}

	public synchronized void withdraw(int amount, String who) {
		System.out.println(who + "가 출금 시작~~");
		System.out.println("출금 전 잔액 " + balance);
		if (balance < amount) {
			System.out.println("잔액부족");
		} else {

			balance -= amount;
		}
		System.out.println("출금 후 잔액 " + balance);
		System.out.println(who + "가 출금 끝~~");
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
