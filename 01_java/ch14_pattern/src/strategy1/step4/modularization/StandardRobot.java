package strategy1.step4.modularization;

import strategy1.step4.component.*;
//임포트 자체는 컨트롤스페이스로
//import strategy1.step4.component.* 로 넣으면 전부 넣어둘 수 있다.
//임포트에서 필요없는 건 컨트롤 시프트 O


public class StandardRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	
	public StandardRobot() {
		fly = new FlyNo();
		missile = new MissileYes();
		knife = new KnifeWood();
		 setFly(new FlyNo());
		 setMissile(new MissileYes());
		 setKnife(new KnifeWood());
	}
	
	//메소드 오버라이드
	
	@Override
	public void actionFly() {
		fly.fly();

	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();

	}
	
	//겟셋

	public IFly getFly() {
		return fly;
	}


	public void setFly(IFly fly) {
		this.fly = fly;
	}


	public IMissile getMissile() {
		return missile;
	}


	public void setMissile(IMissile missile) {
		this.missile = missile;
	}


	public IKnife getKnife() {
		return knife;
	}


	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	
	
}
