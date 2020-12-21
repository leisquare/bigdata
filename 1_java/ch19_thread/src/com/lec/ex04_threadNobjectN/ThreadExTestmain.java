package com.lec.ex04_threadNobjectN;

public class ThreadExTestmain {
public static void main(String[] args) {
	Runnable target1 = new ThreadEx(); //target1.num
	Runnable target2 = new ThreadEx(); //target2.num
	Thread t1 = new Thread(target1, "A");
	Thread t2 = new Thread(target2, "N");
	t1.start();
	t2.start();
	System.out.println("메인함수끝");
}
}
