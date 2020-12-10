package com.lec.ex06_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("매개변수 0개짜리");
	}
	public Friend(String name) {
		this(); //내 객체의 생성자 함수.
		this.name =name; //this : 내 객체를 가리킴.
		System.out.println("매개변수 1개짜리");
	}
	public Friend(String name, String tel) {
		//this.name = name;
		this(name);
		this.tel = tel;
	}
}
