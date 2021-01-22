package com.lec.ex03_phone;

public class TestMain {
	public static void main(String[] args) {
//		IAcor ob = new IAcor; //불가능
//		IAcor phone = new Amodel();
		Amodel aPhone = new Amodel();
		Bmodel bPhone = new Bmodel();
		Cmodel cPhone = new Cmodel();
		IAcor[] phones = { aPhone, bPhone, cPhone };
		for (IAcor phone : phones) {
			// 객체의 클래스타입
			System.out.println(phone.getClass().getName());
			phone.dmbReceive();
			phone.Ite();
			phone.tvRemoteControl();
		}
	}
}



