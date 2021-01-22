package com.lec.ex05_shape;

public class Circle extends Shape {
	private int r;
	public Circle() {}
	public Circle(int r) {
		this.r=r;
	}
	@Override
	public double computeArea() {
//		System.out.println("원넓이는 "+(3.14*r*r));
		return 3.14*r*r;
	}
	@Override
	public void draw() {
		System.out.println("원");
		super.draw();
	}
	public int getR() {
		return r;
	}
}
