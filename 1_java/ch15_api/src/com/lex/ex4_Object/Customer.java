package com.lex.ex4_Object;

//goods - goodCode, goodName,price,stockNum
//customer = tel,name,point,amount

public class Customer {
	private String tel;
	private String name;
	private int point;
	private int amount;

	public Customer(String tel, String name) {
		this.tel = tel;
		this.name = name;
		point = 3000;
	}

	@Override
	public String toString() {
		return tel + name + " " + "포인트: " + point + " 누적 금액 " + amount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj !=null && obj instanceof Customer){   //순서 틀리지 않게! 주의하기
			return tel.contentEquals(((Customer)obj).tel);
		}
		return false;
	}

}
