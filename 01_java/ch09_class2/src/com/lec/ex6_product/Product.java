package com.lec.ex6_product;
// Product p1 = new Product();
public class Product {
	private int serialNo; // 객체 고유의 번호
	public static int count=100;
	public Product() {
		serialNo= ++count;
	}
	public void infoString() {
		System.out.println("serialNo="+serialNo+"\t공유변수count"+count);
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getSerialNo() {
		return serialNo;
	}
}
