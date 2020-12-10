package com.lec.ex12_Account;

public class CheckingAccount extends Account {
	private String cardNo;
	public CheckingAccount(String accountNo,String ownerName, String cardNo){ 
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo,String ownerName, int balance, String cardNo){ 
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int price){
		if(this.cardNo.equals(cardNo)){
			if(getBalance()<price){
				System.out.println("★★★잔액이 부족합니다★★★");
			}else{
				setbalance(getBalance()-price);
				System.out.println("★★★"+price+"사용되서 "+getBalance()+"잔액★★★");
			}
		}else{
			System.out.println("카드번호가 틀려요. 떽기");
		}
	}
	public String getCardNo() {return cardNo;}
	public void setCardNo(String cardNo) {this.cardNo = cardNo;}
}