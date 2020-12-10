package com.lec.ex1_square;

public class Squaremain {
	public static void main(String[] args) {
		Square s1=new Square();
		Square s2=new Square(10);
		System.out.println("s1의 한 변의 길이는 "+s1.getSide());
		System.out.println("s1의 넓이는 "+s1.area());
		System.out.println("s2의 한 변의 길이는 "+s2.getSide());
		System.out.println("s2의 넓이는 "+s2.area());
		s2.setSide(5);
		System.out.println("s2의 한 변의 길이는 "+s2.getSide());
		System.out.println("s2의 넓이는 "+s2.area());
	}
}