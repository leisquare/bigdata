package com.lec.ex02;

public class Testmain {
	public static void main(String[] args) {
//		Super s; //변수만 만드는 건 가능.
//		Super s = new Super();  //이것은 불가능. 추상 클래스는 객체를 생성할 수 없다(추상 메소드 때문에)
//		Super s = new Super() { //임시로 메서드를 정의해주는것,
//		
//			@Override
//			public void method1() {
//				System.out.println("이런건 안드에서만 합니다. 빅데이터에서 쓸 일은 아마도 없음");
//			}
//		};
//		s.method1();
		
		Child c1 = new Child(); //
		c1.method1();
		c1.method2();
		c1.method3();
		Super c2 = new Child(); //
		c2.method1();
		c2.method2();
//		c2.method3();  //c2변수가 super타입이고 super에는 method3이 없어서 이렇다. super것만 가능.	
	}
}
