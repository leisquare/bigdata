package com.lec.ex04_shape;

public abstract class Shape {
	public void draw() {
		System.out.println("도형을 그려요");
	}
	public abstract void computeArea(); //추상ㅁㅔ소드
}
