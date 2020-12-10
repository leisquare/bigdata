package com.lec.ex2_man;

public class ManMain {
	public static void main(String[] args) {
		Man kim = new Man(20, 183, 72, "010-9999-1234");
		Man yi = new Man(20, 183, 59);
		Man kang = new Man(20,"010-1234-6632");
		Man[] student= {kim,yi,kang};
		yi.setTel("010-3242-8643");
		kang.setHeight(180);
		kang.setWeight(65);
		double biman = kim.calculateBMI();
		if(biman>24) {
			System.out.println("비만");			
		}else {
			System.out.println("다이어트 금지");
		}
	}
}