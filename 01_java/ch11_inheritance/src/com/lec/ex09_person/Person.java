package com.lec.ex09_person;
//person p = new Person("홍길동","착하다")

public class Person {
	private String name;
	private String character;

	public Person() {
		System.out.println("매개변수없는 person생성자 호출");
	}

	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수있는 person생성자 호출");
	}

	public void intro() {
		System.out.println(name + "은(는) " + character);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

}
