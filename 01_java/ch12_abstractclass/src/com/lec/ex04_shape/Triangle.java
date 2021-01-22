package com.lec.ex04_shape;

public class Triangle extends Shape {

	private int w; // 밑변
	private int h; // 높이

	public Triangle() {
	}

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public void computeArea() {
		System.out.println("삼각형 넓이는 " + (w * h * 0.5));
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		System.out.println("삼각형");
		super.draw();
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

}
