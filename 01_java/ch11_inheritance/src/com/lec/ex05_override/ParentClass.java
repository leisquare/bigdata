package com.lec.ex05_override;

public class ParentClass {
	//생성자가 2개 : 생성자함수의 오버로딩(함수의 중복정의) 
	public ParentClass() {
		System.out.println("P 매개변수 없는 생성자");
	}
	public ParentClass(int i) {
		System.out.println("P매개변수 있는 생성자");
	}
	public void method1() {
		System.out.println("parent의 Method1()");
	}
	public void method2() {
		System.out.println("parent의 Method2()");
	}
	public void method2(int i) {
		System.out.println("parent의 Method2()");
	}
	//메서드도 오버로딩 가능하지만, return타입만 다른 오버로딩은 불가능함. 예를 들어 지금 아래를 같이 쓸 수는 없다.
//	public int method2() {
//		System.out.println("parent의 Method2");
//	}
	
}
