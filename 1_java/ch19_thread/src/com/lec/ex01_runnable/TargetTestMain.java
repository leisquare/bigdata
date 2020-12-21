package com.lec.ex01_runnable;

public class TargetTestMain {
	public static void main(String[] args) {
		Target target = new Target();
		//A라는 이름의 쓰레드를 생성- target.run()을 수행하는 쓰레드
		Thread t1 = new Thread(target, "A");
		Thread t2 = new Thread(target, "B");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main함수 끝");
	}
}
