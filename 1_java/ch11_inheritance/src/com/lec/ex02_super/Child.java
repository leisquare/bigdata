package com.lec.ex02_super;

public class Child extends SuperIJ {
	private int total;
	public Child(int i, int j) {
//		this.i = i; 를 할 수 없다. 다른 파일에 있는 private이므로
		setI(i);
		setJ(j);
	}
	public void sum() {
		// total에 i+j를 할당.
		// 그러나 total = i+j; 는 할 수 없다(private이라서)
		total = getI() + getJ();
		System.out.println("본 객체의 total: " + total);
	}
}
