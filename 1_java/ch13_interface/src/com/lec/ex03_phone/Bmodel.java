package com.lec.ex03_phone;
//a제품 : DMB송수신불가, 5G, TV리모콘 미탑재

public class Bmodel implements IAcor {

	private String modelName = "B모델";

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 dmb송수신가능");
	}

	@Override
	public void Ite() {

		System.out.println(modelName + "은 LTE모델");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 tv리모콘 탑재.");

	}

}
