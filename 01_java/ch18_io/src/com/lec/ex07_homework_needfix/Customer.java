package com.lec.ex07_homework_needfix;

public class Customer {
	private String name;
	private String tel;
	private String birth;
	private String address;

	public Customer(String name, String tel, String birth, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address;
	}
}
