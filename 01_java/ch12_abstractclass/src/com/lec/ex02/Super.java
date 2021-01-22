package com.lec.ex02;
//추상클래스는 한 개 이상의 추상 메소드를 갖고 있다.
//Super s = new Super();
//s.method1();
//위와 같은 게 불가능하다.
public abstract class Super {
	public Super () {} //추상 크래스에서 생성자는 있어도 없어도 된다.
	public abstract void method1(); //추상 메소드. 선언만 되어있고 호출할수가 없다.
	public void method2() {
		System.out.println("super의 메서드 ");
	}
}
