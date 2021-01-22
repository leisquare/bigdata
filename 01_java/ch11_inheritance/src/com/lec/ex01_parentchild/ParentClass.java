package com.lec.ex01_parentchild;
//상속해준 클래스: parent class, super class, 부모클래스

public class ParentClass {
	String pStr = "부모 클래스";
//생성자
	public ParentClass() {
		System.out.println("부모클래스 객체부분 생성");
	}
//매서드
	public void getPapaName() {
		System.out.println("아빠 이름 홍길동");
	}

	public void getMaminame() {
		System.out.println("엄마 이름 김길순");
	}

}
