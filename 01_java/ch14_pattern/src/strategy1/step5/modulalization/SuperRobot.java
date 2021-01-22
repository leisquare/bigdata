package strategy1.step5.modulalization;

import strategy1.step4.component.*;

//날 수 있음. 미사일 쏨. 레이저 검
public class SuperRobot extends Robot {

	
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}
	@Override
	public void shape() {
		System.out.println("SuperRobot은 팔 다리 머리 몸통으로 이루어져 있다.");
	}
}

