package com.lec.ex07_toy;

public class MazingerToy implements IMissile, IMoveArmLeg{
	public MazingerToy() {
		System.out.println("마징가");
		canMissile();
		canMoveArmLeg();
	}
	
	
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있습니다.");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일 쏠 수 있습니다");
	}
	@Override
	public String toString() {
		return "미사일쏘고 팔다리 움직이는 마징가 장난감";
	}

}
