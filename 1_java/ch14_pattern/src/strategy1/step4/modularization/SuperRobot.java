package strategy1.step4.modularization;

import strategy1.step4.component.*;

//날 수 있음. 미사일 쏨. 레이저 검
public class SuperRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public SuperRobot() {
		fly = new FlyYes();
		missile = new MissileYes();
		knife = new KnifeLazer();
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
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
