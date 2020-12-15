package com.lex.ex4_Object;

public class Rectangle {
	private int width;
	private int length;
	private String color;

	public Rectangle() {
		this.width = 0;
		this.length = 0;
		this.color = "검정";
	}

	public Rectangle(int width, int length, String color) {
		this.width = width;
		this.length = length;
		this.color = color;

	}

	@Override
	public String toString() {
		return "가로" + width + " 세로" + length + "의 " + color + "색 사각형";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Rectangle) {
			boolean widthChk = width == ((Rectangle) obj).width;
			boolean lengthChk = length == ((Rectangle) obj).length;
			boolean colorChk = color.equals(color);
			return widthChk && lengthChk && colorChk;
		}
		return false;
	}

}
