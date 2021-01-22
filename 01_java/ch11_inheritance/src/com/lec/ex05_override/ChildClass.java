package com.lec.ex05_override;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("C 매개변수 없는 생성자");
	}
	public ChildClass(int i) {
		System.out.println("C 매개변수 있는 생성자");
	}
	@Override  //컴파일러에게 알려주는 것. 바로 직후 줄에만 적용된다. 
	public void method1() { //오버라이딩. 함수의 재저으이
		System.out.println("Child의 method1()");
	}
	public void method3() {
		System.out.println("Child의 method3()");
	}
	
	//1은 오버라이드 재정의, 2는 그대로 씀, 3은 여기서 정의.
	//똑같이생긴 함수가 다른 일을 하는 것을 다형성이라고 함.
}
