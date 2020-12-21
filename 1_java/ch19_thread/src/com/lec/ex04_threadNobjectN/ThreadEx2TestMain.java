package com.lec.ex04_threadNobjectN;

public class ThreadEx2TestMain {
	public static void main(String[] args) {
		//t1.run 수행하는 쓰레드 A 생성. t1.num
		Thread t1 = new ThreadEx2("A");		
//		Thread t1 = new ThreadEx2();
//		t1.setName("A"); 이것도 가능 
		
		//t2.run 수행하는 쓰레드 A 생성. t2.num
		
		Thread t2 = new ThreadEx2("B");
		t1.start();
		t2.start();
	}
}
