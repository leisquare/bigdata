package com.lec.ex05_shape;

public abstract class Shape {
	public void draw() {
		System.out.println("도형을 그려요");
	}
	public abstract double computeArea(); //추상 메소드
}
