package com.lec.ex07_toy;

public class Pooh implements IMoveArmLeg {
	public Pooh() {
	System.out.println("곰돌이 푸.");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있습니다.");
	}
	@Override
	public String toString() {
		return "팔다리 움직이는 곰돌이 장난감";
	}
}
