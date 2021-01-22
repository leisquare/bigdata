package com.lec.ex04_actor; //다중 implements를 이용한 다형성

public class TestMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.makePizza();
		park.makeSpaghetti();
		park.outFire();
		park.saveMan();
		System.out.println("****");
		FireFighter firePark=park;
		firePark.outFire();
		firePark.saveMan();
//		firePark.makeSpaghetti();
		PoliceMan policePark = park;
		policePark.canCatchCriminal();
		policePark.canSearch();
//		policePark.saveMan();
		
	}
}
