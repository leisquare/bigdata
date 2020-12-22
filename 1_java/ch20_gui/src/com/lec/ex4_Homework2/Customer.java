package com.lec.ex4_Homework2;

public class Customer {

	private String phone;
	private String name;
	private int point;
	
	public Customer(String phone, String name, int point) {
		super();
		this.phone = phone;
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return  phone + "\t" + name + "\t" + point +"\r";
	}

	public String getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}
	
	
	
}
