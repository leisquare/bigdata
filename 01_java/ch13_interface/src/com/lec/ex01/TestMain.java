package com.lec.ex01;

//InterfaceEx1, InterfaceEx2
//InterfaceClass
public class TestMain {
	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1();	

		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();
//		obj2.method2(); 
		// 불가. InterfaceEx1엔 method2가 없으므로.
		InterfaceEx2 obj3 = new InterfaceClass();
//		obj3.method1(); 불가하다. 
//		if(obj3 instanceof InterfaceClass) {
//			((InterfaceClass)obj3).method1(); 
//		}
//		위와 같이 쓰면 되긴 하지만 일단은 불가능한것으로 보겠다. 

		obj3.method2();
	}
}
