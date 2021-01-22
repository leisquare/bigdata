package com.lec.ex13_final;

//final class 는 상속 불가.
public final class Dog extends Animal {
	@Override
	public void running() {
		super.running();
		speed += 10;
		System.out.println("강아지가 뛰면서 꼬리를 흔들어요. 현 속도: " + speed);
	}

	public void method() {
		System.out.println("method()");
	}
}
