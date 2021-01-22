package com.lec.ex05_threadN_object1;

public class ThreadExTestMain {
	public static void main(String[] args) {
		ThreadEx target = new ThreadEx(); // 작업객체 1개를 n개가 공유
		Thread t1 = new Thread(target, "A");
		Thread t2 = new Thread(target, "B");
		t1.start();
		t2.start();
		System.out.println("메인함수끝");
	}
}
