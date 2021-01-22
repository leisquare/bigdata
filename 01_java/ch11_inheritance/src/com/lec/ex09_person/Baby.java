package com.lec.ex09_person;

public class Baby extends Person {
	public Baby() {
		System.out.println("매개변수없는 baby생성자");
	}

	public Baby(String name, String character) {
		super(name, character);
//		부모단의 생성자함수... 함수의 제일 위에만 올 수 있음
//		매개변수 없는 함수를 실행 못하도록 만드는 것이다.
//		setName(name);
//		setCharacter(character);
		System.out.println("매개변수있는 baby생성자");
	}

	public void cry() {
		System.out.println("응애응애");
	}

	@Override
	public void intro() {
		System.out.println(getName() + "은(는) 아기라서 엄마가 대신 소개한다");
		super.intro();
	}
}