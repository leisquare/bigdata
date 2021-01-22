package com.lec.ex1_square;

//Square s1 = new square()
//Square s2 = new square(10);
//Scanner sc = new Scanner(system.in<키보드에서 들어올때마다 버퍼에 들어온 것을 끌어오는 애)
public class Square {
	private int side;

//	public Square() {} //아무것도 안 하는 디폴트 생성자
	public Square() { // 매개변수 없는 생성자 => 생성자 오버로딩
		System.out.println("매개변수없는 생성자 호출");
	}

	public Square(int side) { //매개변수 있는 생성자
		this.side = side;
		System.out.println("매개변수있는 생성자 호출");
	}

	public int area() {
		return side * side;
	}

	public int getSide() {// ~.getSide() 사용
		return side;
	}

	public void setSide(int side) { // ~.setSide(10)
		this.side = side;

	}
}