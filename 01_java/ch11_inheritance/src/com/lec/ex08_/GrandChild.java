package com.lec.ex08_;

public class GrandChild extends Child1 {
	private int gc = 3;
	public GrandChild() {
		System.out.println("Grandchild형 객체 생성");
	}
	public int getGc() {
		return gc;
	}
	public void setGc(int gc) {
		this.gc = gc;
	}
}
