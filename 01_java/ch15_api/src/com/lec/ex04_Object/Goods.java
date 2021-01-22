package com.lec.ex04_Object;

//goods - goodCode, goodName,price,stockNum
//customer = tel,name,point,amount

public class Goods {
	private String goodCode;
	private String goodName;
	private int price;
	private int stocknum;

	public Goods(String goodCode, String goodName, int price, int stocknum) {
		this.goodCode = goodCode;
		this.goodName = goodName;
		this.price = price;
		this.stocknum = stocknum;
		
	}

	@Override
	public String toString() {
		return goodName+"("+goodCode+")"+"의 가격은  " + price +"남은 수량"+stocknum;
	}

}


