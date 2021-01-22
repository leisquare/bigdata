package com.lec.ex13_final;
/*
 * 2020.12.08 Jiwon Kim
 * 이 로직이 어디에 들어가는지를 설명으로 쓸 것.
 * 
 */

public class Animal {
	protected int speed;

	public void running() {
//		final int TEMP = 10;
//		TEMP +=5;
//		final 쓰면 변경 불가고, 이런 상수는 보통 전부 대문자로 씀.
		speed += 5;
		System.out.println("뛰고있어요. 현재 속도:" + speed);
	}

	public final void stop() {
		speed = 0;
		System.out.println("멈춤");
	}
}
