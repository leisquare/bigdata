package com.lex.ex4_Object;

public class Ex04_RectangleMain {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10, 5, "빨강");
		Rectangle r2 = new Rectangle();
		Rectangle r3 = new Rectangle(0, 0, "검정");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r1.equals(r2));
		System.out.println(r2.equals(r3));
	}

}


