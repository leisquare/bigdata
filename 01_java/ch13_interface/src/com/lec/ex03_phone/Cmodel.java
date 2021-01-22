package com.lec.ex03_phone;

public class Cmodel implements IAcor {
	private String modelName = "C모델";

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
		System.out.println(modelName + "은 tv리모콘 미탑재.");

	}

}
