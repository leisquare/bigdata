package com.lec.ex01;
//InterfaceEx1에는 상수 (CONSTANT_NUM, method1())
//InterfaceEx2에는 상수 (CONSTANT_STRING, method2())
public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {

	@Override
	public void method1() {
		System.out.println("실제 구현은 implement한 클래스에서 합니다.");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String method2() {
		System.out.println("실제 구현은 implement한 클래스에서 합니다.");
		return null;
	}

}
