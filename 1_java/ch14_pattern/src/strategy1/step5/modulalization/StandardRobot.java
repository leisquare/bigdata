package strategy1.step5.modulalization;

import strategy1.step4.component.*;
//임포트 자체는 컨트롤스페이스로
//import strategy1.step4.component.* 로 넣으면 전부 넣어둘 수 있다.
//임포트에서 필요없는 건 컨트롤 시프트 O

public class StandardRobot extends Robot {

	public StandardRobot() {
		 setFly(new FlyNo());
		 setMissile(new MissileYes());
		 setKnife(new KnifeWood());
	}
	@Override
	public void shape() {
		System.out.println("standardRobot은 팔 다리 머리 몸통으로 이루어져 있다.");
	}
}
