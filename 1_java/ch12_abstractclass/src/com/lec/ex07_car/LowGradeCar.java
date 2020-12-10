package com.lec.ex07_car;
//LowGradeCar lowcar – new LowGradeCar(“red”,”광폭”,”2000”,”파워핸들”)
public class LowGradeCar extends Car {
	// 데이터 생성자 메소드 게터세터순서
	private int tax = 50000;

	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getSpec() {
		System.out.println("*******************");
		System.out.println("색  상 : " + getColor());
		System.out.println("타이어 : " + getTire());
		System.out.println("배기량 : " + getDisplacement());
		System.out.println("핸   들 : " + getHandle());
		if (getDisplacement() > 1000) {
			tax += (getDisplacement() - 1000) * 100;
		}
		System.out.println("세   금 : " + tax);
		System.out.println("*******************");

	}
}
