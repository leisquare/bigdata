package com.lec.ex03;

public abstract class ChildClass extends SuperClass {
	//수퍼 클래스로부터 받은 추상메소드 method1을 갖고있기때문에 그것을 오버라이드하던가 아니면 이것도 추상클래스로 만들어야한다.
	@Override
	public void method1() {
		System.out.println("childClass의 method2()");
	}
	public void method3() {
		System.out.println("childClass의 method3()");
	}
}


