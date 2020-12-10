package com.lec.ex4_boxrect;

public class BoxRectMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10); // 3차원 박스
		BoxOrRect rect = new BoxOrRect(10,5);  // 2차원 네모
		box.calNsetVolume();
		rect.calNsetVolume();
		System.out.println("박스 부피 : "+box.getVolume());
		System.out.println("rect 넓이 : "+rect.getVolume());
	}//main
}