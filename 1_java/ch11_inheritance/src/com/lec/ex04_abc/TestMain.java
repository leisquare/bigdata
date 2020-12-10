package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S s = new S();
//		A a = new A();
		S a = new A(); //a객체는 s타입이 가능하다. s를 상속했기 때문.
//		A s = new S();는 안된다. 
//		Object a = new A();
		System.out.println(a.s);  //이것도 a객체에 s타입 주지 않으면 불가... 
		S b = new B();
		S c = new C();
		S[] sArr = {new A(), new B(), new C()};

	}

}
