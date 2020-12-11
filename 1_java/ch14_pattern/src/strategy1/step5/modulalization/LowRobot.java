package strategy1.step5.modulalization;

import strategy1.step4.component.*;

public class LowRobot extends Robot{

	//생성자
	
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	@Override
	public void shape() {
		System.out.println("lowRobot은 팔 다리 머리 몸통으로 이루어져 있다.");
	}
	
}
