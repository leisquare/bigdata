package com.lec.ex06_;

public class TestMain {
	public static void main(String[] args) {
		IRadio aRadio = new IRadio();
		ITv aTv = new ITv();
//		IVolume[] device = {aRadio(3),aTv()};	
		aRadio.volumeUP(3);
		aTv.volumeUP();
	}
}
