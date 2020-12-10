package com.lec.ex01;

//public상수와 추상메소드만 올 수 있다. 
public interface InterfaceEx1 {
	public static final int CONSTANT_NUM = 10;
	// 인터페이스에는 static final 변수(즉, 상수)만 올 수 있으므로 static final을 생략 가능.

	public abstract void method1();
	// 여기도 무조건 추상이기 때문에 abstract 생략 가능.

}
