package strategy1.step4.modularization;

import strategy1.step4.component.*;

public class LowRobot extends Robot{
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	//생성자
	
	public LowRobot() {
		fly = new FlyNo();
		missile = new MissileNo();
		knife = new KnifeNo();
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
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
