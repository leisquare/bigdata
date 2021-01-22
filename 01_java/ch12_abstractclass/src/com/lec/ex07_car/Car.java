package com.lec.ex07_car;
//LowGradeCar lowcar – new LowGradeCar(“red”,”광폭”,”2000”,”파워핸들”)
//red, 광폭 등은 상수로 뺄 것
public abstract class Car {
	
	private String color; // 차색상
	private String tire; //타이어
	private int displacement; //배기량
	private String handle; //핸들
	
	
	public Car(String color, String tire, int displacement, String handle) {
		super();
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}	
	public abstract void getSpec();
	
	public String getColor() {
		return color;
	}
	public String getTire() {
		return tire;
	}
	public int getDisplacement() {
		return displacement;
	}
	public String getHandle() {
		return handle;
	}
	
}


