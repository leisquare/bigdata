package com.lec.ex01_parentchild;

public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.getPapaName();
		child.getMaminame();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}
}
