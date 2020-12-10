package com.lec.ex03;

public class TestMain {
	public static void main(String[] args) {
		//SuperClass super = new SuperClass 는 불가능
		//ChildClass child = new ChildClass 도 불가능. 
		//SuperClass super = new GrandChildClass();  이것은 super가 이미 의미가 있는 예약어라서 사용할 수 없다.
		SuperClass sup = new GrandChildClass();
		sup.method1();
		sup.method2();
		//sup.method3();  이것은 안됨
		ChildClass child = new GrandChildClass();  //변수와 객체는 같은 클래스가 아니어도 된다.
		child.method1();
		child.method2();
		child.method3();
		GrandChildClass grand = new GrandChildClass();
		grand.method1();
		grand.method2();
		grand.method3();
		
	}

}
