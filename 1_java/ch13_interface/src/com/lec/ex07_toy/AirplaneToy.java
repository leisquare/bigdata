package com.lec.ex07_toy;

public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println();
		canLight();
		canMissile();
		System.out.println("====================");
	}

	@Override
	public void canLight() {
		System.out.println("불빛발사 가능합니다");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일 쏠 수 있습니다");

	}
	@Override
	public String toString() {
		return "불빛과 미사일을 쏘는 비행기";
	}

}
