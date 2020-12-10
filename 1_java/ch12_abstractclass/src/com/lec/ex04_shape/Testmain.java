package com.lec.ex04_shape;

public class Testmain {
	public static void main(String[] args) {
//		Shape shape = new shape; //이것은 만들 수 없다. 컴파일 오류 발생

//		Shape shape1 = new Circle(5);
//		Shape shape2 = new Rectangle(10,5);
//		Shape shape3 = new Triangle(5,10);
//		이렇게 쓰지 않고 배열 처리 하겠다.

		Shape[] shape = { new Circle(5), new Rectangle(10, 5), new Triangle(5, 10) };

		for (int i = 0; i <= shape.length; i++) {// {예외발생(실행단계 에러)
			shape[i].draw();
			shape[i].computeArea();
		}

//		for(Shape s : shape) {
//			s.draw();
//			s.computeArea();
//		}

	}
}
