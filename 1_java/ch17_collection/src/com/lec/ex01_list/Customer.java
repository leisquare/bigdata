package com.lec.ex01_list;

public class Customer {
	private String name;
	private String phone;
	private String address;
	//new Customer("홍", "010", "seoul") 이런 형태가 나올 것이므로...

	
	public Customer(String name, String phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	@Override
	public String toString() {
		return name + "\t" + phone + "\t" + address;
		
		
		
	}
}
